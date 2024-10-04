package com.backend.backend.Categoria;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.backend.Categoria.DTO.Categoria_DTO;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class Categoria_Service {

    private final Categoria_Repository categoria_Repository;

    public Categoria createCategoria(Categoria_DTO categoria_DTO){
        Categoria categoria = Categoria.builder()
                .nombre(categoria_DTO.getNombre())
                .subcategoria(categoria_DTO.getSubcategoria())
                .estado(1)
                .build();
        return categoria_Repository.save(categoria);
    }


    public List<Categoria> getAllCategorias(){
        return categoria_Repository.findAll();
    }


    public Categoria updateCategoria(Integer id, Categoria_DTO categoria_DTO){
        Categoria categoriaExistente = categoria_Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada: " + id));

        categoriaExistente.setNombre(categoria_DTO.getNombre());
        categoriaExistente.setSubcategoria(categoria_DTO.getSubcategoria());

        return categoria_Repository.save(categoriaExistente);
    }


    public void deleteCategoria(Integer id){
        Categoria categoriaExistente = categoria_Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada: " + id));
        
        categoriaExistente.setEstado(0);
    }

    public void activateCategoria(Integer id){
        Categoria categoriaExistente = categoria_Repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada: " + id));
        
        categoriaExistente.setEstado(1);
    }
}
