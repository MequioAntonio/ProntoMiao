package it.unical.prontoMiao.controller;

import it.unical.prontoMiao.model.Utente;
import it.unical.prontoMiao.request.AuthRequest;
import it.unical.prontoMiao.response.JwtTokenResponse;
import it.unical.prontoMiao.service.AuthenticationService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticazioneController  {
    @Autowired
    private AuthenticationService authenticationService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody Utente request) {
        try {
            JwtTokenResponse token = authenticationService.login(request);
            return ResponseEntity.ok(authenticationService.login(request));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<Utente> signup(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

}