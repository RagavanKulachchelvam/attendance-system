package com.attendancesystem.server.service;

import com.attendancesystem.server.dto.AuthenticationRequestDto;
import com.attendancesystem.server.dto.AuthenticationResponseDto;
import com.attendancesystem.server.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserDetailsServiceImpl userDetailsService;
    private final JwtService jwtService;

    public AuthenticationResponseDto authenticate(AuthenticationRequestDto authenticationRequest) {
        Optional<User> userOpt = userDetailsService.findUserByUsername(authenticationRequest.getUsername());

        if (userOpt.isEmpty() || !userOpt.get().getPassword().equals(authenticationRequest.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        User user = userOpt.get();
        String jwtToken = jwtService.generateToken(new HashMap<>(), user);

        return AuthenticationResponseDto.builder().token(jwtToken).build();
    }
}
