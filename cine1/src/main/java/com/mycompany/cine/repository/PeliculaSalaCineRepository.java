package com.mycompany.cine.repository;
import com.mycompany.cine.model.PeliculaSalaCine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface PeliculaSalaCineRepository extends JpaRepository<PeliculaSalaCine, Integer> {
    
    // Al ponerle el @Query, Spring ya no se confunde con el guion bajo
    @Query("SELECT p FROM PeliculaSalaCine p WHERE p.fecha_publicacion = :fecha")
    List<PeliculaSalaCine> findByFecha_publicacion(@Param("fecha") LocalDate fecha_publicacion);
}