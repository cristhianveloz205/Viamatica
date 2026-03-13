package com.mycompany.cine.repository;
import com.mycompany.cine.model.PeliculaSalaCine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface PeliculaSalaCineRepository extends JpaRepository<PeliculaSalaCine, Integer> {
    
    @Query("SELECT p FROM PeliculaSalaCine p WHERE p.fechaPublicacion = :fecha")
    List<PeliculaSalaCine> findByFechaPublicacion(@Param("fecha") LocalDate fechaPublicacion);

    boolean existsByPelicula_IdPeliculaAndSalaCine_IdSala(Integer idPelicula, Integer idSala);
}