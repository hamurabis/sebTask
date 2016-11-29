package bundle.suggestion.bundle;

import java.util.ArrayList;
import java.util.List;

public class CustomBundle {
	
	private String bundleName;
	
	private List<String> productsToAdd = new ArrayList<String>();
	
	private List<String> productsToRemove = new ArrayList<String>();

	public String getBundleName() {
		return bundleName;
	}

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	public List<String> getProductsToAdd() {
		return productsToAdd;
	}

	public void setProductsToAdd(List<String> productsToAdd) {
		this.productsToAdd = productsToAdd;
	}

	public List<String> getProductsToRemove() {
		return productsToRemove;
	}

	public void setProductsToRemove(List<String> productsToRemove) {
		this.productsToRemove = productsToRemove;
	}

}
