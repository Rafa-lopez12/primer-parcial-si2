package com.backend.backend.Rol;

import com.backend.backend.Funcionalidades.Funcionalidad_Repository;
import com.backend.backend.Funcionalidades.Funcionalidades;
import com.backend.backend.Rol.DTO.DTO_Rol;
import com.backend.backend.Rol_Funcional.Rol_Funcional;
import com.backend.backend.Rol_Funcional.Rol_Funcional_Repository;
import com.backend.backend.Rol_Funcional.DTO.Rol_Funcional_DTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Rol_Service {
    private final Rol_Repository rolRepository;
    private final Funcionalidad_Repository funcionalidad_Repositoryy;
    private final Rol_Funcional_Repository rol_Funcional_Repositoryy;

    public Rol_Service(Rol_Repository rol_Repository, Funcionalidad_Repository funcionalidad_Repository, Rol_Funcional_Repository rol_Funcional_Repository){
        this.funcionalidad_Repositoryy=funcionalidad_Repository;
        this.rolRepository=rol_Repository;
        this.rol_Funcional_Repositoryy=rol_Funcional_Repository;
    }



    public Rol createRol(DTO_Rol dtoRol) {
        System.out.println(dtoRol);
        if (rolRepository.existsByNombre(dtoRol.getNombre())) {
            throw new RuntimeException("El rol ya existe");
        }

        Rol rol = Rol.builder()
                .nombre(dtoRol.getNombre())
                .descripcion(dtoRol.getDescripcion())
                .build();

        
        rol= rolRepository.save(rol);
        for(Rol_Funcional_DTO rol_FuncionalDto : dtoRol.getRol_funcional()){
            Funcionalidades funcionalidades=funcionalidad_Repositoryy.findById(rol_FuncionalDto.getIdFuncionalidad())
                    .orElseThrow(() -> new IllegalArgumentException("Funcionalidad no encontrado"));
            
            Rol_Funcional rol_Funcional= Rol_Funcional.builder()
                    .rol(rol)
                    .funcionalidades(funcionalidades)
                    .build();

            rol.addRol_Fun(rol_Funcional);
                   
                    
        }

        return rolRepository.save(rol);
    }

    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }

    public Rol getRol(Integer id){
        return rolRepository.getReferenceById(id);
    }
}
