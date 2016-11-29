package bundle.suggestion.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import bundle.suggestion.bundle.Bundle;
import bundle.suggestion.bundle.CustomBundle;
import bundle.suggestion.customer.Customer;
import bundle.suggestion.products.Product;
import bundle.suggestion.rest.SuggestionStatus;
import bundle.suggestion.rules.Rule;

/**
 * Bundle suggestion implementation
 * 
 * @author MG
 *
 */
public class BundleServiceImpl implements BundleService{
	
	/**
	 * Possible bundles to suggest
	 */
	private Map<String, Bundle> bundlesMap;
	
	private Map<String, Product> productsMap;

	/**
	 * {@inheritDoc}
	 * 
	 * Iterates in bundles list and validates if bundle is valid
	 */
	public Bundle suggest(Customer customer) {
		Bundle result = null;
		for (Entry<String, Bundle> entry : bundlesMap.entrySet()) {
			Bundle bundle = entry.getValue();
			SuggestionStatus productsStatus = validateProducts(customer, bundle.getProducts());
			SuggestionStatus bundleStatus = validateBundle(customer, bundle);
			boolean addBundle = productsStatus.getErrors().isEmpty() && bundleStatus.getErrors().isEmpty();
			if (addBundle && (result == null || result.getRatingValue() < bundle.getRatingValue())) {
				result = bundle;
			}
		}
		return result;
	}

	/**
	 * Method for validating products, it iterates through products rules and checks if all passes
	 * 
	 * @return error messages if at least one rule failed
	 */
	protected SuggestionStatus validateProducts(Customer customer, List<Product> products) {
		SuggestionStatus status = new SuggestionStatus();
		for (Product product : products) {
			for (Rule rule : product.getRules()) {
				if (!rule.validate(customer) || !rule.validate(products)) {
					status.getErrors().add(rule.getMessage());
				}
			}
		}
		return status;
	}
	
	/**
	 * Method for validating bundle, it iterates through bundle rules and checks if all passes
	 * 
	 * @return error messages if at least one rule failed
	 */
	protected SuggestionStatus validateBundle(Customer customer, Bundle bundle) {
		SuggestionStatus status = new SuggestionStatus();
		for (Rule rule : bundle.getRules()) {
			if (!rule.validate(customer) || !rule.validate(bundle.getProducts())) {
				status.getErrors().add(rule.getMessage());
			}
		}
		return status;
	}
	
	/**
	 * Method for validating custom bundle, it iterates through bundle rules, all products rules
	 *  and checks if all passes
	 *  
	 *  @return error messages if at least one rule failed
	 */
	public SuggestionStatus validatesCustomBundle(Customer customer, CustomBundle customBundle) {
		SuggestionStatus combinedStatus = new SuggestionStatus();
		List<Product> newBundleProducts = new ArrayList<Product>();
		for (String productName : customBundle.getProductsToAdd()) {
			Product product = productsMap.get(productName);
			if (product != null) {
				newBundleProducts.add(product);
			}
		}
		Bundle existingBundle = bundlesMap.get(customBundle.getBundleName());
		if (existingBundle == null) {
			combinedStatus.getErrors().add("Bundle not found");
			return combinedStatus;
		}
		addExistingBundleProducts(customBundle, newBundleProducts, existingBundle);
		
		SuggestionStatus validProducts = validateProducts(customer, newBundleProducts);
		SuggestionStatus validBundle = validateBundle(customer, existingBundle);
		combinedStatus.getErrors().addAll(validProducts.getErrors());
		combinedStatus.getErrors().addAll(validBundle.getErrors());
		return combinedStatus;
	}

	/**
	 * Updates new bundle products by adding only needed products from existing bundle
	 * 
	 * @param customBundle holds information about bundle changes
	 * @param newBundleProducts all new -bundle products
	 * @param existingBundle holds information about existing bundle
	 * 
	 * @author MG
	 */
	protected void addExistingBundleProducts(CustomBundle customBundle, List<Product> newBundleProducts,
			Bundle existingBundle) {
		for(Product product : existingBundle.getProducts()) {
			boolean remove = false;
			for (String removeName : customBundle.getProductsToRemove()) {
				if (removeName.equals(product.getName())) {
					remove = true;
				}
			}
			if (!remove) {
				newBundleProducts.add(product);
			}
		}
	}

	public Map<String, Product> getProductsMap() {
		return productsMap;
	}

	public void setProductsMap(Map<String, Product> productsMap) {
		this.productsMap = productsMap;
	}

	public Map<String, Bundle> getBundlesMap() {
		return bundlesMap;
	}

	public void setBundlesMap(Map<String, Bundle> bundlesMap) {
		this.bundlesMap = bundlesMap;
	}

}
