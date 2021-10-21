package org.aluismarte.test.auth.controller;

import org.aluismarte.test.auth.domain.Product;
import org.aluismarte.test.auth.model.*;
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
@RequestMapping("/api")
public class ProductController {

    // TODO create error handling

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }


    @Transactional
    @PreAuthorize("hasAuthority(@R.PRODUCT_CREATORS)")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<CreateProductResponse> createProduct(@Valid CreateProductRequest createProductRequest) {
        productRepository.save(createProductRequest.toProduct());
        return ResponseEntity.ok(new CreateProductResponse());
    }

    @Transactional
    @PreAuthorize("hasAuthority(@R.PRODUCT_MANAGERS)")
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResponseEntity<ModifyProductResponse> modifyProduct(@Valid ModifyProductRequest modifyProductRequest) {
        return ResponseEntity.ok(new ModifyProductResponse());
    }

    @Transactional
    @PreAuthorize("hasAuthority(@R.PRODUCT_MANAGERS)")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<DeleteProductResponse> deleteProduct(@Valid DeleteProductRequest deleteProductRequest) {
        return ResponseEntity.ok(new DeleteProductResponse());
    }

    @Transactional
    @PreAuthorize("hasAuthority(@R.PRODUCT_PRICING)")
    @RequestMapping(value = "/modify/price", method = RequestMethod.POST)
    public ResponseEntity<ModifyPriceProductResponse> modifyPriceProduct(@Valid ModifyPriceProductRequest modifyPriceProductRequest) {
        return ResponseEntity.ok(new ModifyPriceProductResponse());
    }

    // TODO test and demo functionality

    @PreAuthorize("hasAuthority(@R.PRODUCT_CREATORS)")
    @RequestMapping(value = "/secured", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllSecured() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @PreAuthorize("hasAuthority(@R.PRODUCT_MANAGERS)")
    @RequestMapping(value = "/secured2", method = RequestMethod.GET)
    public ResponseEntity<String> getAllSecured2() {
        return ResponseEntity.ok("Managers");
    }
}
