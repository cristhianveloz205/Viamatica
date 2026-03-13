package com.mycompany.cine.repository;
import com.mycompany.cine.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    // Queries derivados para filtrar únicamente los registros que no han sido eliminados lógicamente
    List<Pelicula> findByEstadoLogicoTrue();
    List<Pelicula> findByNombreContainingIgnoreCaseAndEstadoLogicoTrue(String nombre);
}
