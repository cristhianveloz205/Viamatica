package com.mycompany.cine.controller;
import com.mycompany.cine.model.Pelicula;
import com.mycompany.cine.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    @Autowired private PeliculaService service;

    @PostMapping
    public ResponseEntity<Pelicula> crear(@RequestBody Pelicula p) { return ResponseEntity.ok(service.crear(p)); }

    @GetMapping
    public ResponseEntity<List<Pelicula>> listar() { return ResponseEntity.ok(service.listarTodas()); }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizar(@PathVariable Integer id, @RequestBody Pelicula p) {
        Pelicula act = service.actualizar(id, p);
        return act != null ? ResponseEntity.ok(act) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        return service.eliminarLogico(id) ? ResponseEntity.ok("Eliminada") : ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Pelicula>> buscarNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @GetMapping("/por-fecha")
    public ResponseEntity<?> buscarFecha(@RequestParam String fecha) {
        try { return ResponseEntity.ok(service.buscarPorFecha(fecha)); } 
        catch (Exception e) { return ResponseEntity.badRequest().body("Use AAAA-MM-DD"); }
    }

    @GetMapping("/sala/{nombre}")
    public ResponseEntity<String> validarSala(@PathVariable String nombre) {
        return ResponseEntity.ok(service.validarSala(nombre));
    }
}