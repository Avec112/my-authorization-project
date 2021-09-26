package io.avec.resourceserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(@CurrentSecurityContext(expression = "authentication.name")
                                                       String name) {
        return new ResponseEntity<>("Hello '" + name + "'. It works!", HttpStatus.ACCEPTED);
    }

    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> onlyAdmin(@CurrentSecurityContext(expression = "authentication.name")
                                                        String name) {
        return new ResponseEntity<>("For admins only. You are " + name, HttpStatus.ACCEPTED);
    }
}
