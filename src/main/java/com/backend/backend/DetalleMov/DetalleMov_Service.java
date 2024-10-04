package com.backend.backend.DetalleMov;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleMov_Service {
    private final DetalleMov_Repository detalleMov_Repository;


    public List<DetalleMov> getAllDetalleMov(){
        return detalleMov_Repository.findAll();
    }
}
