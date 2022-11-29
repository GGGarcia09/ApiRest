package com.user.control.controller;



import com.user.control.exceptions.ResourceError;
import com.user.control.model.usuarios;
import com.user.control.repository.usuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class usuariosController {

    @Autowired
    private usuariosRepository repository;

    // lista usuarios
    @GetMapping("/usuarios")
    public List<usuarios> listaDeUsuarios() {
        return repository.findAll();
    }

    //Guarda usuarios
    @PostMapping("/usuarios")
    public usuarios guardarUsuario(@RequestBody usuarios usuarios) {
        return repository.save(usuarios);
    }

    //Eliminar usuarios
    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(@PathVariable Long id) {
        usuarios usuario = repository.findById(id).orElseThrow(() -> new ResourceError("No existe el usuario:" + id));

        repository.delete(usuario);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
    //Actualizacion de usuarios
    @PutMapping("/empleados/{id}")
    public ResponseEntity<usuarios> actualizarEmpleado(@PathVariable Long id, @RequestBody usuarios detallesUsuarios) {
        usuarios usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceError("No existe el usuario: " + id));

        usuario.setNombre(detallesUsuarios.getNombre());
        usuario.setEmail(detallesUsuarios.getEmail());
        usuario.setGender(detallesUsuarios.getGender());
        usuario.setEstatus(detallesUsuarios.getEstatus());

        usuarios usuarioActualizado = repository.save(usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }
}
