package bundle.suggestion.rules;

import bundle.suggestion.customer.Customer;

/**
 * Rule for validating minimum income
 * 
 * @author MG
 *
 */
public class MinimumIncomeRule extends AbstractRule{
	
	/**
	 * Holds minimum income to validate
	 */
	private Integer minimumIncome;

	/**
	 * Validates customer income by comparing it with minimumIncome
	 */
	public boolean validate(Customer customer) {
		if (minimumIncome == null) {
			return true;
		}
		return minimumIncome < customer.getIncome();
	}

	public Integer getMinimumIncome() {
		return minimumIncome;
	}

	public void setMinimumIncome(Integer minimumIncome) {
		this.minimumIncome = minimumIncome;
	}

}
