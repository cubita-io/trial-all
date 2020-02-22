package io.cubita.trial.spring.security.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String aa, String bb) {
        System.out.println(aa);
        System.out.println(bb);
        return "hello";
    }
}