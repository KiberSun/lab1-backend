package org.krytev.lab_devops1.backend_microservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.krytev.lab_devops1.backend_microservice.service.MainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> writeString(@RequestBody String string){
        try {
            mainService.writeString(string);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> getString(){
        return ResponseEntity.ok().body(mainService.getString());
    }

}
