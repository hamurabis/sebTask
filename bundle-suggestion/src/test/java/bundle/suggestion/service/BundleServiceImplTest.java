package bundle.suggestion.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;

import org.junit.Test;

import bundle.suggestion.bundle.Bundle;
import bundle.suggestion.bundle.CustomBundle;
import bundle.suggestion.customer.Customer;
import bundle.suggestion.products.Product;
import bundle.suggestion.rest.SuggestionStatus;
import bundle.suggestion.rules.MinimumAgeRule;

/**
 * Unit Test for BundleServiceImpl
 * 
 * @author MG
 *
 */
public class BundleServiceImplTest {
	
	private BundleServiceImpl service = new BundleServiceImpl();

	@Test
	public void shouldSuggestBundle() {
		// given
		Customer customer = new Customer();
		customer.setAge(20);
		Bundle testBundle = createBundleWithMinimumAgeProductRule("TestBundle", 17);
		service.setBundlesMap(new HashMap<String, Bundle>());
		service.getBundlesMap().put("TestBundle", testBundle);
		
		// when
		Bundle result = service.suggest(customer);
		
		// then
		assertThat(result.getBundleName(), equalTo("TestBundle"));	
	}
	
	@Test
	public void shouldNotSuggestBundle() {
		// given
		Customer customer = new Customer();
		customer.setAge(2);
		Bundle testBundle = createBundleWithMinimumAgeProductRule("TestBundle", 17);
		service.setBundlesMap(new HashMap<String, Bundle>());
		service.getBundlesMap().put("TestBundle", testBundle);
		
		// when
		Bundle result = service.suggest(customer);
		
		// then
		assertThat(result, equalTo(null));	
	}
	
	@Test
	public void shouldSuggestBundleWithBundleRule() {
		// given
		Customer customer = new Customer();
		customer.setAge(20);
		Bundle testBundle = createBundleWithMinimumAgeBundleRule("TestBundle", 17);
		service.setBundlesMap(new HashMap<String, Bundle>());
		service.getBundlesMap().put("TestBundle", testBundle);
		
		// when
		Bundle result = service.suggest(customer);
		
		// then
		assertThat(result.getBundleName(), equalTo("TestBundle"));	
	}
	
	@Test
	public void shouldNotSuggestBundleWithBundleRule() {
		// given
		Customer customer = new Customer();
		customer.setAge(2);
		Bundle testBundle = createBundleWithMinimumAgeBundleRule("TestBundle", 17);
		service.setBundlesMap(new HashMap<String, Bundle>());
		service.getBundlesMap().put("TestBundle", testBundle);
		
		// when
		Bundle result = service.suggest(customer);
		
		// then
		assertThat(result, equalTo(null));	
	}
	
	@Test
	public void shouldPassCustomBundleValidation() {
		// given
		Customer customer = new Customer();
		customer.setAge(20);
		Bundle testBundle = createBundleWithMinimumAgeBundleRule("TestBundle", 17);
		CustomBundle customBundle = new CustomBundle();
		customBundle.setBundleName("TestBundle");
		service.setBundlesMap(new HashMap<String, Bundle>());
		service.getBundlesMap().put("TestBundle", testBundle);
		
		// when
		SuggestionStatus result = service.validatesCustomBundle(customer, customBundle);
		
		// then
		assertThat(result.getErrors().size(), equalTo(0));	
	}
	
	@Test
	public void shouldNotPassCustomBundleValidation() {
		// given
		Customer customer = new Customer();
		customer.setAge(10);
		Bundle testBundle = createBundleWithMinimumAgeBundleRule("TestBundle", 17);
		CustomBundle customBundle = new CustomBundle();
		customBundle.setBundleName("TestBundle");
		service.setBundlesMap(new HashMap<String, Bundle>());
		service.getBundlesMap().put("TestBundle", testBundle);
		
		// when
		SuggestionStatus result = service.validatesCustomBundle(customer, customBundle);
		
		// then
		assertThat(result.getErrors().size(), equalTo(1));	
	}
	
	private Bundle createBundleWithMinimumAgeBundleRule(String name, int age) {
		Bundle testBundle = new Bundle();
		testBundle.setBundleName(name);
		MinimumAgeRule testRule = new MinimumAgeRule();
		testRule.setMinimumAge(age);
		testRule.setMessage("Test");
		testBundle.getRules().add(testRule);
		return testBundle;
	}

	private Bundle createBundleWithMinimumAgeProductRule(String name, int age) {
		Bundle testBundle = new Bundle();
		testBundle.setBundleName(name);
		Product testProduct = new Product();
		MinimumAgeRule testRule = new MinimumAgeRule();
		testRule.setMinimumAge(age);
		testRule.setMessage("Test");
		testProduct.getRules().add(testRule);
		testBundle.getProducts().add(testProduct);
		return testBundle;
	}

}
