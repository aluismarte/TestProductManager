package org.aluismarte.test.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Easy mode to create and admin users to test
 *
 * Created by Aluis on 10/21/2021.
 */
@RestController
public class UserController {

    // TODO create some services to manipulate users

    @GetMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }
}
