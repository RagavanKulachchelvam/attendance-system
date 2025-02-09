package com.attendancesystem.server.controller;

import com.attendancesystem.server.dto.AuthenticationRequestDto;
import com.attendancesystem.server.dto.AuthenticationResponseDto;
import com.attendancesystem.server.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> authenticate(
            @RequestBody @Valid AuthenticationRequestDto authenticationRequest
    ) {
        log.info("Authenticating user: {}", authenticationRequest.getUsername());
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}
