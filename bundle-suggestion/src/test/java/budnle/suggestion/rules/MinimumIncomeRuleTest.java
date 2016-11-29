package budnle.suggestion.rules;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

import bundle.suggestion.customer.Customer;
import bundle.suggestion.rules.MinimumAgeRule;
import bundle.suggestion.rules.MinimumIncomeRule;

/**
 * Unit test for MinimumIncomeRule
 * 
 * @author MG
 *
 */
public class MinimumIncomeRuleTest {

	@Test
	public void shouldPassValidation() {
		// given
		MinimumIncomeRule rule = new MinimumIncomeRule();
		rule.setMinimumIncome(20);
		Customer customer = new Customer();
		customer.setIncome(22);
		
		// when
		assertThat(rule.validate(customer), equalTo(true));
	}
	
	@Test
	public void shouldNotPassValidation() {
		// given
		MinimumIncomeRule rule = new MinimumIncomeRule();
		rule.setMinimumIncome(20);
		Customer customer = new Customer();
		customer.setIncome(19);
		
		// when
		assertThat(rule.validate(customer), equalTo(false));
	}

}
