package com.sd22.dbproject.controllers;

import com.sd22.dbproject.dto.AuthDto;
import com.sd22.dbproject.dto.LoginDto;
import com.sd22.dbproject.dto.RegisterDto;
import com.sd22.dbproject.entities.Role;
import com.sd22.dbproject.entities.User;
import com.sd22.dbproject.security.jwt.JwtAuthToken;
import com.sd22.dbproject.services.RoleService;
import com.sd22.dbproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserService userService;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    private JwtAuthToken jwtAuthToken;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserService userService, RoleService roleService, PasswordEncoder passwordEncoder, JwtAuthToken jwtAuthToken) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.jwtAuthToken = jwtAuthToken;
    }

    @PostMapping("login")
    public ResponseEntity<AuthDto> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtAuthToken.generateToken(authentication);
        return new ResponseEntity<>(new AuthDto(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        if(userService.existsByUsername(registerDto.getEmail())){
            return new ResponseEntity<>("Username is already in use", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Role role = roleService.findRoleByName("USER").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRoles(userRoles);

        userService.addUser(user);

        return new ResponseEntity<>("User registered success", HttpStatus.OK);
    }
}
