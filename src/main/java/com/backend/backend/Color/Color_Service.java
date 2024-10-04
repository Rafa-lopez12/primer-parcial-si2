package com.backend.backend.Color;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.backend.Categoria.DTO.Categoria_DTO;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Color_Service {

    private final Color_Repository color_Repository;

    public List<Color> getAllColor(){
        return color_Repository.findAll();
    }
}
