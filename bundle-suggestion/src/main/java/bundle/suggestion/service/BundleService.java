package bundle.suggestion.service;

import bundle.suggestion.bundle.Bundle;
import bundle.suggestion.bundle.CustomBundle;
import bundle.suggestion.customer.Customer;
import bundle.suggestion.rest.SuggestionStatus;

/**
 * Service for suggesting bundles
 * 
 * @author MG
 *
 */
public interface BundleService {
	
	/**
	 * Suggest bundle by provided customer info 
	 * 
	 * @param customer bundle is selected using this information
	 * @return selected suggestion for customer, <code>null</code> if not found
	 */
	public Bundle suggest(Customer customer);
	
	/**
	 * Validates if bundle could be used
	 * 
	 * @param customer which is validated in method
	 * @return suggestion status for customer
	 */
	public SuggestionStatus validatesCustomBundle(Customer customer, CustomBundle bundle);

}
