package bundle.suggestion.rules;

import java.util.List;

import bundle.suggestion.products.Product;

/**
 * Rule for validating if product in required products collection
 * 
 * @author MG
 *
 */
public class ProductInRangeRule extends AbstractRule{
	
	/**
	 * Variable holds products collection which defines required products
	 */
	private List<Product> atLeastOneProduct;

	/**
	 * Validates product by checking if its in atLeastOneProduct collection
	 */
	public boolean validate(List<Product> products) {
	    if (atLeastOneProduct == null || products == null) {
            return true;
        }
	    for (Product product : products) {
	        if (atLeastOneProduct.contains(product)) {
	            return true;
	        }
	    }
		return false;
	}

	public List<Product> getAtLeastOneProduct() {
		return atLeastOneProduct;
	}

	public void setAtLeastOneProduct(List<Product> atLeastOneProduct) {
		this.atLeastOneProduct = atLeastOneProduct;
	}

}
