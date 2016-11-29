package budnle.suggestion.rules;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

import bundle.suggestion.customer.Customer;
import bundle.suggestion.products.Product;
import bundle.suggestion.rules.MaximumAgeRule;
import bundle.suggestion.rules.MinimumAgeRule;

/**
 * Unit test for MinimumAgeRule
 * 
 * @author MG
 *
 */
public class MinimumAgeRuleTest {

	@Test
	public void shouldPassValidation() {
		// given
		MinimumAgeRule rule = new MinimumAgeRule();
		rule.setMinimumAge(20);
		Customer customer = new Customer();
		customer.setAge(22);
		
		// when
		assertThat(rule.validate(customer), equalTo(true));
	}
	
	@Test
	public void shouldNotPassValidation() {
		// given
		MinimumAgeRule rule = new MinimumAgeRule();
		rule.setMinimumAge(20);
		Customer customer = new Customer();
		customer.setAge(19);
		
		// when
		assertThat(rule.validate(customer), equalTo(false));
	}

}
