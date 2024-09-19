package com.evaluacion.evaluacion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluacion.evaluacion.Models.Tarea;
import com.evaluacion.evaluacion.interfaceService.ItareaService;

@RequestMapping("/api/v1/Tarea/")
@RestController
public class tareaController {

    @Autowired
    private ItareaService tareaService;

    @PostMapping("/")
    public ResponseEntity<Object> save (@ModelAttribute("Tarea") Tarea Tarea) {

        if (Tarea.getTitle().equals("")) {
            return new ResponseEntity<>("Campo title es obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (Tarea.getAssignedTo().equals("")) {
            return new ResponseEntity<>("Campo assignedTo es obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        tareaService.save(Tarea);
        return new ResponseEntity<>(Tarea, HttpStatus.OK);
    }

     @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        var listaTarea = tareaService.findAll();
        return new ResponseEntity<>(listaTarea, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable String id) {
        var Tarea = tareaService.findOne(id);
        return new ResponseEntity<>(Tarea, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarPermanente/{id}")
    public ResponseEntity<Object> deleteForever(@PathVariable String id) {
        tareaService.deleteForever(id);
    return new ResponseEntity<>("Registro eliminado permanentemente", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("Tarea") Tarea TareaUpdate) {
        var Tarea = tareaService.findOne(id).get();
        if (Tarea != null) {

            Tarea.setTitle(TareaUpdate.getTitle());
            Tarea.setDueDate(TareaUpdate.getDueDate());
            Tarea.setAssignedTo(TareaUpdate.getAssignedTo());
            Tarea.setStatus(TareaUpdate.getStatus());
         
            tareaService.save(Tarea);
            return new ResponseEntity<>(Tarea, HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Error tarea NO Encontrado", HttpStatus.BAD_REQUEST);
        }
    }


}
