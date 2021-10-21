package org.aluismarte.test.auth.job.batch.processor;

import org.aluismarte.test.auth.domain.Product;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by aluis on 9/2/20.
 */
@Component
@StepScope
public class ProductsProcessor implements ItemProcessor<Product, Product> {

    @Override
    public Product process(Product product) {
        if (product.isHaveChanges()) {
            return product;
        }
        return null;
    }
}
