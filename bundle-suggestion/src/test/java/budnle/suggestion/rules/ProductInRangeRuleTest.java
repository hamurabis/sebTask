package budnle.suggestion.rules;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bundle.suggestion.customer.Customer;
import bundle.suggestion.products.Product;
import bundle.suggestion.rules.MinimumAgeRule;
import bundle.suggestion.rules.ProductInRangeRule;

/**
 * Unit test for ProductInRangeRule
 * 
 * @author MG
 *
 */
public class ProductInRangeRuleTest {

	@Test
	public void shouldPassValidation() {
		// given
		ProductInRangeRule rule = new ProductInRangeRule();
		rule.setAtLeastOneProduct(new ArrayList<Product>());
		Product product = new Product();
		product.setName("TestName");
		rule.getAtLeastOneProduct().add(product);
		
		// when
		assertThat(rule.validate(rule.getAtLeastOneProduct()), equalTo(true));
	}
	
	@Test
	public void shouldNotPassValidation() {
		// given
		ProductInRangeRule rule = new ProductInRangeRule();
		rule.setAtLeastOneProduct(new ArrayList<Product>());
		Product product = new Product();
		product.setName("TestName");
		rule.getAtLeastOneProduct().add(product);
		Product product2 = new Product();
		product.setName("TestName2");
		List<Product> products = new ArrayList<Product>();
		products.add(product2);
		
		// when
		assertThat(rule.validate(products), equalTo(false));
	}

}
