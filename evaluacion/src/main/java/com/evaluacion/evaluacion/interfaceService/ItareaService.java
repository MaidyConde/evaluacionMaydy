package com.evaluacion.evaluacion.interfaceService;

import java.util.List;
import java.util.Optional;

import com.evaluacion.evaluacion.Models.Tarea;

public interface ItareaService {

    public String save (Tarea Tarea);

    public List<Tarea> findAll();

    public Optional<Tarea> findOne(String id);

    public int delete(String id);

}
