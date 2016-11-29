package bundle.suggestion.rules;

import bundle.suggestion.customer.Customer;

/**
 * Rule for validating student status
 * 
 * @author MG
 *
 */
public class StudentRule extends AbstractRule{
	
	/**
	 * Holds if customer should be student
	 */
	private Boolean isStudent;

	/**
	 * Validates customer by comparing its student status with isStudent variable 
	 */
	public boolean validate(Customer customer) {
		if (isStudent == null) {
			return true;
		}
		return isStudent == customer.isStudent();
	}

	public Boolean isStudent() {
		return isStudent;
	}

	public void setStudent(Boolean isStudent) {
		this.isStudent = isStudent;
	}

}
