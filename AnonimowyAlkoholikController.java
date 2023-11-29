package com.example.wyszukiwarka_lotow.controllers;

import com.example.wyszukiwarka_lotow.models.AndroidRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aa")
public class AnonimowyAlkoholikController {

    @PostMapping("/postFlights")
    AndroidRequest postFlight(@RequestBody AndroidRequest androidRequest){
        return androidRequest;
    }
}
