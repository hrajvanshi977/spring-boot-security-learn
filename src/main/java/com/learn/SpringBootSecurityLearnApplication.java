package com.learn;

import com.learn.models.User;
import com.learn.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityLearnApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setEmail("himanshu@gmail.com");
        user1.setUsername("himanshu");
        user1.setPassword(this.bCryptPasswordEncoder.encode("himanshu"));
        user1.setRole("ROLE_NORMAL");
        user1.setTenantName("Finnova");

        this.userRepository.save(user1);

        User user2 = new User();
        user2.setEmail("rahul@gmail.com");
        user2.setUsername("rahul");
        user2.setPassword(this.bCryptPasswordEncoder.encode("rahul"));
        user2.setRole("ROLE_ADMIN");
        user2.setTenantName("Ess Kay");
        this.userRepository.save(user2);
    }
}
