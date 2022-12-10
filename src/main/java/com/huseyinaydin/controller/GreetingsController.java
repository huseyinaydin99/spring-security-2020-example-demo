package com.huseyinaydin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*@author Hüseyin Aydın
 */

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingsController {
    @GetMapping("/say-hello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Selamun aleyküm hacı abi");
    }

    @GetMapping("/say-good-bye")
    public ResponseEntity<String> sayGoodBye(){
        return ResponseEntity.ok("Hadi görüşürük çüüzz.! :D");
    }
}
