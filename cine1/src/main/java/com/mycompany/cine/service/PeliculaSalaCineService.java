package com.mycompany.cine.service;
import com.mycompany.cine.model.Pelicula;
import com.mycompany.cine.model.PeliculaSalaCine;
import com.mycompany.cine.model.SalaCine;
import com.mycompany.cine.repository.PeliculaRepository;
import com.mycompany.cine.repository.PeliculaSalaCineRepository;
import com.mycompany.cine.repository.SalaCineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaSalaCineService {
    @Autowired private PeliculaSalaCineRepository asignacionRepo;
    @Autowired private PeliculaRepository peliculaRepo;
    @Autowired private SalaCineRepository salaRepo;

    public PeliculaSalaCine asignarPelicula(Integer idPelicula, Integer idSala, PeliculaSalaCine asignacion) {
        // Validación de duplicados: Evita registrar la misma película en la misma sala
        if (asignacionRepo.existsByPelicula_IdPeliculaAndSalaCine_IdSala(idPelicula, idSala)) {
            throw new RuntimeException("Error: La película ya está en esta sala.");
        }
        Pelicula p = peliculaRepo.findById(idPelicula).orElseThrow(() -> new RuntimeException("Película no hallada"));
        SalaCine s = salaRepo.findById(idSala).orElseThrow(() -> new RuntimeException("Sala no hallada"));

        asignacion.setPelicula(p);
        asignacion.setSalaCine(s);
        return asignacionRepo.save(asignacion);
    }
}
