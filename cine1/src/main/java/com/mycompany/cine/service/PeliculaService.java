package com.mycompany.cine.service;
import com.mycompany.cine.dto.PeliculaRequestDTO;
import com.mycompany.cine.dto.PeliculaResponseDTO;
import com.mycompany.cine.model.Pelicula;
import com.mycompany.cine.model.PeliculaSalaCine;
import com.mycompany.cine.repository.PeliculaRepository;
import com.mycompany.cine.repository.PeliculaSalaCineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeliculaService {
    @Autowired private PeliculaRepository peliculaRepo;
    @Autowired private PeliculaSalaCineRepository peliculaSalaRepo;
// Método utilitario para mapear la Entidad a un DTO de respuesta
    private PeliculaResponseDTO convertir(Pelicula p) {
        return new PeliculaResponseDTO(p.getIdPelicula(), p.getNombre(), p.getDuracion());
    }

    public PeliculaResponseDTO crear(PeliculaRequestDTO dto) {
        Pelicula p = new Pelicula();
        p.setNombre(dto.getNombre());
        p.setDuracion(dto.getDuracion());
        return convertir(peliculaRepo.save(p));
    }

    public List<PeliculaResponseDTO> listarTodas() {
        return peliculaRepo.findByEstadoLogicoTrue().stream().map(this::convertir).collect(Collectors.toList());
    }

    public PeliculaResponseDTO actualizar(Integer id, PeliculaRequestDTO dto) {
        Pelicula p = peliculaRepo.findById(id).orElseThrow(() -> new RuntimeException("Película no existe"));
        p.setNombre(dto.getNombre());
        p.setDuracion(dto.getDuracion());
        return convertir(peliculaRepo.save(p));
    }
// Ejecuta una eliminación suave (soft delete) cambiando el estado lógico a false
    public void eliminarLogico(Integer id) {
        Pelicula p = peliculaRepo.findById(id).orElseThrow(() -> new RuntimeException("Película no existe"));
        p.setEstadoLogico(false);
        peliculaRepo.save(p);
    }

    public List<PeliculaResponseDTO> buscarPorNombre(String nombre) {
        return peliculaRepo.findByNombreContainingIgnoreCaseAndEstadoLogicoTrue(nombre)
                .stream().map(this::convertir).collect(Collectors.toList());
    }

    public List<PeliculaResponseDTO> buscarPorFecha(String fechaStr) {
        LocalDate fecha = LocalDate.parse(fechaStr);
        return peliculaSalaRepo.findByFechaPublicacion(fecha).stream()
                .map(PeliculaSalaCine::getPelicula).filter(Pelicula::getEstadoLogico)
                .map(this::convertir).collect(Collectors.toList());
    }
}
