package bundle.suggestion.rules;

import bundle.suggestion.customer.Customer;

/**
 * Rule for minimum customer age
 * 
 * @author MG
 *
 */
public class MinimumAgeRule extends AbstractRule{
	
	/**
	 * Holds minimum age allowed
	 */
	private Integer minimumAge;

	/**
	 * Validates customer age by comparing it with minimumAge variable
	 */
	public boolean validate(Customer customer) {
		if (minimumAge == null) {
			return true;
		}
		return minimumAge < customer.getAge();
	}

	public Integer getMinimumAge() {
		return minimumAge;
	}

	public void setMinimumAge(Integer minimumAge) {
		this.minimumAge = minimumAge;
	}

}
