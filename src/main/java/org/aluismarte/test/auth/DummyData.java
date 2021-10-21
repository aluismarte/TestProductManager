package org.aluismarte.test.auth;

import org.aluismarte.test.auth.domain.Product;
import org.aluismarte.test.auth.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Podria hacerse por SQL, pero es mas rapido de esta forma con motivos de test
 * <p>
 * Created by Aluis on 10/21/2021.
 */
@Component
public class DummyData implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DummyData(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {
        productRepository.save(new Product(null, "Uva", 150.0, false, false));
        productRepository.save(new Product(null, "Manzana", 60.0, false, false));
        System.out.println("Finish insert");
    }
}
