package bundle.suggestion.rules;

import bundle.suggestion.customer.Customer;
import bundle.suggestion.products.Product;

/**
 * Rules used to validate bundle or product acceptability
 * 
 * @author MG
 *
 */
public interface Rule {
	
	/**
	 * Validates if customer is acceptable
	 * 
	 * @param customer to validate
	 * @return <code>true</code> if customer is acceptable, <code>false</code> otherwise
	 */
	public boolean validate(Customer customer);
	
	/**
	 * Validates if product is acceptable
	 * 
	 * @param product to validate
	 * @return <code>true</code> if product is acceptable, <code>false</code> otherwise
	 */
	public boolean validate(Product product);
	
	/**
	 * @return Validation message
	 */
	public String getMessage();

}
