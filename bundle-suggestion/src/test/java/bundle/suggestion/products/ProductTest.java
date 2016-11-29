package bundle.suggestion.products;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * Unit test for Product
 * 
 * @author MG
 *
 */
public class ProductTest {

	@Test
	public void shouldCheckIsProductsEquals() {
		// given
		Product product = new Product();
		product.setName("TestName");
		
		// then
		assertThat(product.equals(product), equalTo(true));
	}
	
	@Test
	public void shouldCheckIsProductsNotEquals() {
		// given
		Product product = new Product();
		product.setName("TestName");
		Product product2 = new Product();
		product.setName("TestName2");
		
		// then
		assertThat(product.equals(product2), equalTo(false));
	}

}
