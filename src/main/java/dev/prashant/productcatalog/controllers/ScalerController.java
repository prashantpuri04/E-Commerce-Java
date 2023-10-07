package dev.prashant.productcatalog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScalerController {

    @GetMapping("/hi")
    public String hiEveryOne(){
        return "Hey everyone from prashant";
    }
}
