package org.aluismarte.test.auth;

import org.aluismarte.test.auth.domain.Product;
import org.aluismarte.test.auth.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Podria hacerse por SQL, pero es mas rapido de esta forma con motivos de test
 * <p>
 * Created by Aluis on 10/21/2021.
 */
@Component
public class DummyData implements CommandLineRunner {

    public static final String PRODUCT_CREATORS = "PRODUCT_CREATORS";
    public static final String PRODUCT_MANAGERS = "PRODUCT_MANAGERS";
    public static final String PRODUCT_PRICING = "PRODUCT_PRICING";

    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;

    public DummyData(ProductRepository productRepository, PasswordEncoder passwordEncoder) {
        this.productRepository = productRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null, "Uva", 150.0));
        productRepository.save(new Product(null, "Manzana", 60.0));

        System.out.println("Finish insert");
    }
}
