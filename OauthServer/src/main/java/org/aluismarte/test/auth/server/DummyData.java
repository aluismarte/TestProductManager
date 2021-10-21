package org.aluismarte.test.auth.server;

import org.aluismarte.test.auth.server.domain.Role;
import org.aluismarte.test.auth.server.domain.User;
import org.aluismarte.test.auth.server.repository.RoleRepository;
import org.aluismarte.test.auth.server.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Podria hacerse por SQL, pero es mas rapido de esta forma con motivos de test
 * <p>
 * Created by Aluis on 10/21/2021.
 */
@Component
public class DummyData implements CommandLineRunner {

    public static final String PRODUCT_CREATORS = "PRODUCT_CREATORS";
    public static final String PRODUCT_MANAGERS = "PRODUCT_MANAGERS";
    public static final String PRODUCT_PRICING = "PRODUCT_PRICING";

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DummyData(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        Role product_creators = roleRepository.save(new Role(null, PRODUCT_CREATORS));
        Role product_managers = roleRepository.save(new Role(null, PRODUCT_MANAGERS));
        Role product_pricing = roleRepository.save(new Role(null, PRODUCT_PRICING));

//        userRepository.save(new User(null, "Creator", "Demo", "creator@aluis.com", "demo", true, Set.of(product_creators)));
        userRepository.save(new User(null, "Creator", "Demo", "creator@aluis.com", passwordEncoder.encode("demo"), true, Set.of(product_creators)));
        userRepository.save(new User(null, "Manager", "Demo", "manager@aluis.com", passwordEncoder.encode("demo"), true, Set.of(product_managers)));
        userRepository.save(new User(null, "Admin", "Demo", "admin@aluis.com", passwordEncoder.encode("demo"), true, Set.of(product_pricing)));
        System.out.println("Finish insert");
    }
}
