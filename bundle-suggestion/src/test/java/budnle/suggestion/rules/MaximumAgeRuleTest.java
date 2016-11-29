package budnle.suggestion.rules;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import bundle.suggestion.customer.Customer;
import bundle.suggestion.rules.MaximumAgeRule;
/**
 * Unit test for MaximumAgeRule
 * 
 * @author MG
 *
 */
public class MaximumAgeRuleTest {

	@Test
	public void shouldPassValidation() {
		// given
		MaximumAgeRule rule = new MaximumAgeRule();
		rule.setMaximumAge(20);
		Customer customer = new Customer();
		customer.setAge(19);
		
		// when
		assertThat(rule.validate(customer), equalTo(true));
	}
	
	@Test
	public void shouldNotPassValidation() {
		// given
		MaximumAgeRule rule = new MaximumAgeRule();
		rule.setMaximumAge(20);
		Customer customer = new Customer();
		customer.setAge(22);
		
		// when
		assertThat(rule.validate(customer), equalTo(false));
	}

}
