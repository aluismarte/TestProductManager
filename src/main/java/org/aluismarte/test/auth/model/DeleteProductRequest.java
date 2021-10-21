package org.aluismarte.test.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by Aluis on 10/21/2021.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeleteProductRequest {

    @NotNull
    private Long id;
}
