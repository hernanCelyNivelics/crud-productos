package com.producto.demoProductos.producto.controller;

import com.producto.demoProductos.producto.dto.AuthenticationRequest;
import com.producto.demoProductos.producto.dto.AuthenticationResponse;
import com.producto.demoProductos.producto.security.JWTUtil;
import com.producto.demoProductos.producto.service.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public AuthenticationResponse createToken(@RequestBody AuthenticationRequest request) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()));


        }catch (BadCredentialsException e){
            throw new Exception("credenciales invalidas",e);
        }
        UserDetails userDetails = usuarioDetailsService.loadUserByUsername(request.getUsername());
        String jwt= jwtUtil.GenerateToken(userDetails);
        return new AuthenticationResponse(jwt);
    }


}
