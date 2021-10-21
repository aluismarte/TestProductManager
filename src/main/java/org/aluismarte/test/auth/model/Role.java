package org.aluismarte.test.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by Aluis on 10/21/2021.
 */
@Component("R")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    public static final String PRODUCT_CREATORS = "PRODUCT_CREATORS";
    public static final String PRODUCT_MANAGERS = "PRODUCT_MANAGERS";
    public static final String PRODUCT_PRICING = "PRODUCT_PRICING";


    @JsonProperty
    private String authority;
}
