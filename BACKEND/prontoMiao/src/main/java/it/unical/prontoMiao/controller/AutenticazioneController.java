package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.persistenza.model.Utente;
import it.unical.prontoMiao.request.AuthRequest;
import it.unical.prontoMiao.response.JwtTokenResponse;
import it.unical.prontoMiao.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4210", "http://localhost:4220"})
@RequestMapping("/auth")
public class AutenticazioneController  {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Utente request) {
        try {
            JwtTokenResponse token = authenticationService.login(request);
            return ResponseEntity.ok(authenticationService.login(request));
        } catch (IllegalArgumentException | SQLException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Utente> signup(@RequestBody AuthRequest request) {
        try {
            return ResponseEntity.ok(authenticationService.signup(request));
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

}