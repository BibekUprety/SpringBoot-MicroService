package com.bibek.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBackMethod")
    public String userServiceFallBackMethod() {
        return "User Service is getting long time " + "please try again";
    }

    @GetMapping("/departmentServiceFallBackMethod")
    public String departmentServiceFallBackMethod() {
        return "department Service is getting long time " + "please try again";
    }
}
