package bundle.suggestion.rules;

import java.util.List;

import bundle.suggestion.customer.Customer;
import bundle.suggestion.products.Product;

/**
 * Abstract rule which used to have common logic for all rules
 * 
 * @author MG
 *
 */
public abstract class AbstractRule implements Rule{
	
	/**
	 * Rule validation error messages
	 */
	private String message;
	
	/**
	 * Default implementation
	 * 
	 * @return always return <code>true</code>
	 */
	public boolean validate(Customer customer) {
		return true;
	}

	/**
	 * Default implementation
	 * 
	 * @return always return <code>true</code>
	 */
	public boolean validate(List<Product> products) {
		return true;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
