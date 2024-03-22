package com.example.ams.service;

import com.example.ams.auth.JwtAuthenticationResponse;
import com.example.ams.auth.SignInRequest;
import com.example.ams.model.LogPass;
import com.example.ams.entity.Role;
import com.example.ams.entity.User;
import com.example.ams.generate.LoginGenerator;
import com.example.ams.generate.SecurePasswordGenerator;
import com.example.ams.model.UserFullName;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public LogPass signUp(UserFullName userInputData){
        LogPass logPass = new LogPass(LoginGenerator.generateLogin(userInputData.getFull_name()),
                SecurePasswordGenerator.generateSecurePassword());
        logPass.setLogin(makeLoginUnique(logPass.getLogin()));

        var user = User.builder()
                .username(logPass.getLogin())
                .password(logPass.getPassword())
                .role(Role.ROLE_USER)
                .build();

        userService.create(user);
        return logPass;
    }
    private String makeLoginUnique(String login){
        int count = 0;
        String newLogin = login;
        boolean isUnique = false;
        while (!isUnique) {
            try {
                userService.getByUsername(newLogin);
            } catch (Exception e) {
                isUnique = true;
            }

            if (!isUnique) {
                count++;
                newLogin = (login + count + "");
            }
        }

        return newLogin;
    }

    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getLogin(),
                request.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getLogin());

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
}
