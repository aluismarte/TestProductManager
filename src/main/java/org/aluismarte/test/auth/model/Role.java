package org.aluismarte.test.auth.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Aluis on 10/21/2021.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @JsonProperty
    private String authority;
}
