package com.example.feastfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feastfinder.model.Signup;
import com.example.feastfinder.service.SignService;

@RestController
@RequestMapping("/sign")
public class SignController {

    @Autowired
    private SignService signService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Signup signup) {
        Signup sign = signService.getUser(signup.getEmailId());
        if (sign == null) {
            signService.signup(signup);
            return new ResponseEntity<>("Signed Up successfully", HttpStatus.CREATED);
            
        }
        return new ResponseEntity<>("EmailId already exists, please use another EmailId", HttpStatus.NOT_ACCEPTABLE);
       
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam String emailId, @RequestParam String password) {
        Signup log = signService.loginCheck(emailId, password);
        if (log == null) {
            return new ResponseEntity<String>("Invalid Email Id or password", HttpStatus.NOT_FOUND);
            
        }
        return new ResponseEntity<String>("Login Successful", HttpStatus.ACCEPTED);
   
    }
}
