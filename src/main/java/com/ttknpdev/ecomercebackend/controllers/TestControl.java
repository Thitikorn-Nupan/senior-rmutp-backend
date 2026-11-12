package com.ttknpdev.ecomercebackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(value = "/api/test")
public class TestControl {
    @GetMapping("/1")
    private String test() {
        return "Hello World";
    }
}
