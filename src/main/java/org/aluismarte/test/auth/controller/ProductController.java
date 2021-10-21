package org.aluismarte.test.auth.controller;

import org.aluismarte.test.auth.domain.Product;
import org.aluismarte.test.auth.model.CreateProductRequest;
import org.aluismarte.test.auth.model.CreateProductResponse;
import org.aluismarte.test.auth.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Aluis on 10/21/2021.
 */
@Validated
@RestController
public class ProductController {

    // TODO create error handling

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @PreAuthorize("hasAuthority('PRODUCT_CREATORS')")
    @RequestMapping(value = "/secured", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllSecured() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @Transactional
    @PreAuthorize("hasAuthority('PRODUCT_CREATORS')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CreateProductResponse> createProduct(@Valid CreateProductRequest createProductRequest) {
        productRepository.save(createProductRequest.toProduct());
        return ResponseEntity.ok(new CreateProductResponse());
    }
}
