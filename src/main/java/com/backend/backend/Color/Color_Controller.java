package com.backend.backend.Color;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/color")
@RequiredArgsConstructor
public class Color_Controller {

    private final Color_Service color_Service;

    @GetMapping()
    public ResponseEntity<List<Color>> getAllColors(){
        List<Color> colors=color_Service.getAllColor();
        return ResponseEntity.ok(colors);
    }
}
