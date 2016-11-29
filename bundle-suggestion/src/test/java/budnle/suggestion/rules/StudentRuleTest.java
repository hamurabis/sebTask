package budnle.suggestion.rules;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

import bundle.suggestion.customer.Customer;
import bundle.suggestion.rules.MinimumIncomeRule;
import bundle.suggestion.rules.StudentRule;

/**
 * Unti test for StudentRule
 * 
 * @author MG
 *
 */
public class StudentRuleTest {

	@Test
	public void shouldPassValidation() {
		// given
		StudentRule rule = new StudentRule();
		rule.setStudent(true);
		Customer customer = new Customer();
		customer.setStudent(true);
		
		// when
		assertThat(rule.validate(customer), equalTo(true));
	}
	
	@Test
	public void shouldNotPassValidation() {
		// given
		StudentRule rule = new StudentRule();
		rule.setStudent(true);
		Customer customer = new Customer();
		customer.setStudent(false);
		
		// when
		assertThat(rule.validate(customer), equalTo(false));
	}

}
