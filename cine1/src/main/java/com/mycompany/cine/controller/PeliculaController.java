package com.mycompany.cine.controller;
import com.mycompany.cine.dto.PeliculaRequestDTO;
import com.mycompany.cine.dto.PeliculaResponseDTO;
import com.mycompany.cine.service.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    @Autowired private PeliculaService service;
    
// @Valid indica a Spring que ejecute las reglas de validación definidas en el DTO
    @PostMapping
    public ResponseEntity<PeliculaResponseDTO> crear(@Valid @RequestBody PeliculaRequestDTO dto) { 
        return ResponseEntity.ok(service.crear(dto)); 
    }

    @GetMapping
    public ResponseEntity<List<PeliculaResponseDTO>> listar() { 
        return ResponseEntity.ok(service.listarTodas()); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaResponseDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody PeliculaRequestDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        service.eliminarLogico(id);
        return ResponseEntity.ok("Eliminada");
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<PeliculaResponseDTO>> buscarNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @GetMapping("/por-fecha")
    public ResponseEntity<List<PeliculaResponseDTO>> buscarFecha(@RequestParam String fecha) {
        return ResponseEntity.ok(service.buscarPorFecha(fecha));
    }
}
