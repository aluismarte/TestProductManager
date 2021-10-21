package org.aluismarte.test.auth.server.service;

import org.aluismarte.test.auth.server.domain.User;
import org.aluismarte.test.auth.server.model.CustomUserDetail;
import org.aluismarte.test.auth.server.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Aluis on 10/21/2021.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> usersOptional = userRepository.findByEmail(username);
        usersOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        return usersOptional
                .map(CustomUserDetail::new)
                .get();
    }
}
