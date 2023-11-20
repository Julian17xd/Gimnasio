package com.example.Gimnasio.repository;

import com.example.Gimnasio.model.ReservaGimnasio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryReservaGimnasio extends JpaRepository<ReservaGimnasio, Integer>{
}