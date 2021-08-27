package com.producto.demoProductos.producto.web.controller;

import com.producto.demoProductos.producto.domain.dto.AuthenticationRequestDto;
import com.producto.demoProductos.producto.domain.dto.AuthenticationResponseDto;
import com.producto.demoProductos.producto.security.JWTUtil;
import com.producto.demoProductos.producto.domain.service.UsuarioDetailsService;
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
    public ResponseEntity<AuthenticationResponseDto> createToken(@RequestBody AuthenticationRequestDto request) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()));
            UserDetails userDetails = usuarioDetailsService.loadUserByUsername(request.getUsername());
            String jwt= jwtUtil.GenerateToken(userDetails);

            return new ResponseEntity<>(new AuthenticationResponseDto(jwt), HttpStatus.OK);

        }catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
