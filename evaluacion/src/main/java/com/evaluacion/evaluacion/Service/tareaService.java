package com.evaluacion.evaluacion.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluacion.evaluacion.Models.Tarea;
import com.evaluacion.evaluacion.interfaceService.ItareaService;
import com.evaluacion.evaluacion.interfaces.Itarea;


@Service
public class tareaService implements ItareaService {

    @Autowired
    private Itarea data;

    @Override 
    public String save(Tarea Tarea) {
        data.save(Tarea);
        return Tarea.getId();
    }

    @Override
    public List<Tarea> findAll() {
        List<Tarea> listaTarea = (List<Tarea>) data.findAll();
        return listaTarea;
    }

    @Override
    public Optional<Tarea> findOne(String id) {
        Optional<Tarea> Tarea = data.findById(id);
        return Tarea;
    }

    @Override
    public int delete(String id) {
        data.deleteById(id);
        return 1;
    }


}
