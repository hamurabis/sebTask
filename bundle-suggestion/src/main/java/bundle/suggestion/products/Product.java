package bundle.suggestion.products;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import bundle.suggestion.rules.Rule;

/**
 * Represents product with its rules
 * 
 * @author MG
 *
 */
public class Product {
	
	/**
	 * Product name
	 */
	private String name;
	
	/**
	 * Rules not needed in response
	 */
	@JsonIgnore
	private List<Rule> rules = new ArrayList<Rule>();
	
	/**
	 * Identifies if product is account type
	 */
	@JsonIgnore
	private boolean isAccount;
	
	/**
	 * Overrides equals method which compares product names, used to 
	 * find if product exists in product list.
	 */
	@Override
	public boolean equals(Object object) {
		if (object instanceof Product) {
			Product product = (Product) object;
			if (name != null) {
				return name.equals(product.name);
			}
		}
		return super.equals(object);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public boolean isAccount() {
		return isAccount;
	}

	public void setAccount(boolean isAccount) {
		this.isAccount = isAccount;
	}

}
