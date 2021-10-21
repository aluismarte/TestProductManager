package org.aluismarte.test.auth.job.batch.writer;

import org.aluismarte.test.auth.domain.Product;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by aluis on 10/21/2021.
 */
@Component
public class ProductWriter extends JpaItemWriter<Product> {

    public ProductWriter(EntityManagerFactory entityManagerFactory) {
        setEntityManagerFactory(entityManagerFactory);
    }

    @Override
    protected void doWrite(EntityManager entityManager, List<? extends Product> items) {
        super.doWrite(entityManager, items.stream().filter(Objects::nonNull).collect(Collectors.toList()));
    }
}
