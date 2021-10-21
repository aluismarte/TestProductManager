package org.aluismarte.test.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aluismarte.test.auth.domain.Product;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Created by Aluis on 10/21/2021.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProductRequest {

    @NotNull
    private String name;

    @NotNull
    @Positive
    private Double price;

    public Product toProduct() {
        return new Product(null, name, price, false, false);
    }
}
