package com.backend.backend.Color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Color_Repository extends JpaRepository<Color, Integer> {
}
