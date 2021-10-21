package org.aluismarte.test.auth.job.batch.reader;

import org.aluismarte.test.auth.domain.Product;
import org.aluismarte.test.auth.repository.ProductRepository;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aluis on 9/2/20.
 */
@Component
public class ProductsReader extends RepositoryItemReader<Product> {

    public ProductsReader(ProductRepository productRepository) {
        setRepository(productRepository);
        setMethodName("findAllByHaveChangesIsTrue");
        setPageSize(100);
        Map<String, Sort.Direction> sort = new HashMap<>();
        sort.put("id", Sort.Direction.ASC);
        setSort(sort);
    }
}
