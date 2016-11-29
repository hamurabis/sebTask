/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package bundle.suggestion.rules;

import java.util.List;

import bundle.suggestion.products.Product;

/**
 * Validates if at least one account is present
 * 
 * @author MG
 *
 */
public class AtLeastOneAccountRule extends AbstractRule {
    
    /**
     * Validates if at least one account is present
     */
    @Override
    public boolean validate(List<Product> products) {
        for (Product product : products) {
            if(product.isAccount()) {
                return true;
            }
        }
        return false;
    }

}
