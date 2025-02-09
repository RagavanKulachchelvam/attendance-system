package com.attendancesystem.server.service;

import com.attendancesystem.server.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String USERS_FILE_PATH = "src/main/resources/users.txt";

    public Optional<User> findUserByUsername(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length == 2 && userDetails[0].equals(username)) {
                    return Optional.of(new User(userDetails[0], userDetails[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
