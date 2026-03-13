package com.mycompany.cine.repository;
import com.mycompany.cine.model.SalaCine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SalaCineRepository extends JpaRepository<SalaCine, Integer> {
    // Ejecuta la función almacenada nativa de MySQL para validar la disponibilidad
    @Query(value = "SELECT contar_peliculas_por_sala(:nombreSala)", nativeQuery = true)
    Integer contarPeliculasPorSala(@Param("nombreSala") String nombreSala);
}
