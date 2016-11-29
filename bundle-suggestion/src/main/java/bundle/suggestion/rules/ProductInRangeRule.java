package bundle.suggestion.rules;

import java.util.List;

import bundle.suggestion.products.Product;

/**
 * Rule for validating if product in required products colleciton
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
	 * Validates product by checking if its in atLeastOneProduct colelction
	 */
	public boolean validate(Product product) {
		if (atLeastOneProduct == null || product == null) {
			return true;
		}
		return atLeastOneProduct.contains(product);
	}

	public List<Product> getAtLeastOneProduct() {
		return atLeastOneProduct;
	}

	public void setAtLeastOneProduct(List<Product> atLeastOneProduct) {
		this.atLeastOneProduct = atLeastOneProduct;
	}

}
