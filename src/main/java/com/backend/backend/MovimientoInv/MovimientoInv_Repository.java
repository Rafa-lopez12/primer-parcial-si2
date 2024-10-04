package com.backend.backend.MovimientoInv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoInv_Repository extends JpaRepository<MovimientoInv, Integer>  {
    
}
