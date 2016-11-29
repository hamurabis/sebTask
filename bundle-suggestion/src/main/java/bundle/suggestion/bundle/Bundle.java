package bundle.suggestion.bundle;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import bundle.suggestion.products.Product;
import bundle.suggestion.rules.Rule;

/**
 * Bundle represents products bundle
 * 
 * @author MG
 *
 */
public class Bundle {
	
	private String bundleName;
	
	private List<Product> products = new ArrayList<Product>();
	
	@JsonIgnore
	private List<Rule> rules = new ArrayList<Rule>();
	
	@JsonIgnore
	private int ratingValue;

	public String getBundleName() {
		return bundleName;
	}

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(int ratingValue) {
		this.ratingValue = ratingValue;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

}
