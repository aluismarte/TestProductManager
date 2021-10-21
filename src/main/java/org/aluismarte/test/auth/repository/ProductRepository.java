package org.aluismarte.test.auth.repository;

import org.aluismarte.test.auth.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Aluis on 10/21/2021.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByHaveChangesIsTrueAndDeletedIsFalse(Pageable pageable);
}
