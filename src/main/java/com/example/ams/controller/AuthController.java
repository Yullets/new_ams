package com.example.ams.controller;

import com.example.ams.auth.JwtAuthenticationResponse;
import com.example.ams.auth.SignInRequest;
import com.example.ams.model.LogPass;
import com.example.ams.model.UserCredentials;
import com.example.ams.model.UserFullName;
import com.example.ams.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/send_to_time_tracking")
    @ResponseBody
    public ResponseEntity signUp(@RequestBody @Valid UserFullName request) {
        LogPass logPass=authenticationService.signUp(request);
        return new ResponseEntity(
                new UserCredentials(request.getFull_name(),
                logPass.getLogin(),
                logPass.getPassword()
                )
                ,HttpStatus.OK);
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }
}
