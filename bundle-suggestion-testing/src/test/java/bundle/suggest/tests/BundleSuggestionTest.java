package bundle.suggest.tests;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class BundleSuggestionTest {

	@Test
	public void shouldSuggestBundle() throws IOException, ParseException {
		//given
		URL url = new URL("http://localhost:8090/bundle-suggestion/services/suggest?age=10&income=0&isStudent=true");
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		
		// when
		assertThat(conn.getResponseCode(), equalTo(201));
		
		Scanner scan = new Scanner(url.openStream());
		String str = new String();
		while (scan.hasNext()) {
			str += scan.nextLine();
		}
		scan.close();
		conn.disconnect();
		
		JSONParser parser = new JSONParser();
		parser.parse(str);
		JSONObject jsonObject = (JSONObject) parser.parse(str);
		
		// then
		String bundleName = (String) jsonObject.get("bundleName");
		
		assertThat(bundleName, equalTo("Junior Saver"));
	}
	
	@Test
	public void shouldCustomizeBundle() throws IOException, ParseException {
		//given
		URL url = new URL("http://localhost:8090/bundle-suggestion/services/custom?age=20&income=50000&isStudent=true");
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);
		conn.setRequestProperty( "Content-Type", "application/json" );
		conn.connect();
		JSONObject parameter = new JSONObject();
		parameter.put("bundleName", "Classic");
		JSONArray productToAddd = new JSONArray();
		productToAddd.add("Credit Card");
		parameter.put("productsToAdd", productToAddd);
		JSONArray productToRemove = new JSONArray();
		productToRemove.add("Debit Card");
		parameter.put("productsToRemove", productToRemove);
        OutputStream os = conn.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
        osw.write(parameter.toString());
        osw.flush();
        osw.close();
        os.close();
		
		// then
		assertThat(conn.getResponseCode(), equalTo(200));
	}

}
