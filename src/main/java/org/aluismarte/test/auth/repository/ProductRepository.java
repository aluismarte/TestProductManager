package org.aluismarte.test.auth.repository;

import org.aluismarte.test.auth.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Aluis on 10/21/2021.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByHaveChangesIsTrue(Pageable pageable);
}
