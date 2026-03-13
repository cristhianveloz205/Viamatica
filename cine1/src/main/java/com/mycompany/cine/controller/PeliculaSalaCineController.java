package com.mycompany.cine.controller;
import com.mycompany.cine.model.PeliculaSalaCine;
import com.mycompany.cine.service.PeliculaSalaCineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/asignaciones")
public class PeliculaSalaCineController {
    @Autowired private PeliculaSalaCineService service;

    @PostMapping("/{idPelicula}/{idSala}")
    public ResponseEntity<PeliculaSalaCine> asignar(
            @PathVariable Integer idPelicula, 
            @PathVariable Integer idSala, 
            @RequestBody PeliculaSalaCine asignacion) {
        return ResponseEntity.ok(service.asignarPelicula(idPelicula, idSala, asignacion));
    }
}