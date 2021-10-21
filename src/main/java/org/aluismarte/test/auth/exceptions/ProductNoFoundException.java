package org.aluismarte.test.auth.exceptions;

/**
 * Created by Aluis on 10/21/2021.
 */
public class ProductNoFoundException extends RuntimeException {

    public ProductNoFoundException() {
        super("Product no found");
    }
}
