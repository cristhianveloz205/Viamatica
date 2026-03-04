package com.mycompany.cine.service;
import com.mycompany.cine.model.*;
import com.mycompany.cine.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeliculaService {
    @Autowired private PeliculaRepository peliculaRepo;
    @Autowired private PeliculaSalaCineRepository peliculaSalaRepo;
    @Autowired private SalaCineRepository salaCineRepo;

    public Pelicula crear(Pelicula p) { return peliculaRepo.save(p); }
    public List<Pelicula> listarTodas() { return peliculaRepo.findByEstadoTrue(); }
    
    public Pelicula actualizar(Integer id, Pelicula pActualizada) {
        Pelicula p = peliculaRepo.findById(id).orElse(null);
        if (p != null) {
            p.setNombre(pActualizada.getNombre());
            p.setDuracion(pActualizada.getDuracion());
            return peliculaRepo.save(p);
        }
        return null;
    }

    public boolean eliminarLogico(Integer id) {
        Pelicula p = peliculaRepo.findById(id).orElse(null);
        if (p != null) {
            p.setEstado(false);
            peliculaRepo.save(p);
            return true;
        }
        return false;
    }

    public List<Pelicula> buscarPorNombre(String nombre) {
        return peliculaRepo.findByNombreContainingIgnoreCaseAndEstadoTrue(nombre);
    }

    public List<Pelicula> buscarPorFecha(String fechaStr) {
        LocalDate fecha = LocalDate.parse(fechaStr);
        return peliculaSalaRepo.findByFecha_publicacion(fecha).stream()
                               .map(PeliculaSalaCine::getPelicula)
                               .collect(Collectors.toList());
    }

    public String validarSala(String nombreSala) {
        Integer cantidad = salaCineRepo.contarPeliculasPorSala(nombreSala);
        if (cantidad < 3) return "Sala disponible";
        if (cantidad <= 5) return "Sala con " + cantidad + " películas asignadas";
        return "Sala no disponible";
    }
}