package bundle.suggestion.rules;

import bundle.suggestion.customer.Customer;
import bundle.suggestion.products.Product;

/**
 * Rule for maximum age
 * 
 * @author MG
 *
 */
public class MaximumAgeRule extends AbstractRule{
	
	/**
	 * Identifies maximum customer age
	 */
	private Integer maximumAge;

	/**
	 * Validates customer age, compares with maximumAge varaible
	 */
	public boolean validate(Customer customer) {
		if (maximumAge == null) {
			return true;
		}
		return maximumAge > customer.getAge();
	}

	public Integer getMaximumAge() {
		return maximumAge;
	}

	public void setMaximumAge(Integer maximumAge) {
		this.maximumAge = maximumAge;
	}

}
