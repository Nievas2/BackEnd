/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import com.example.demo.Entity.Persona;
import com.example.demo.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PersonaController {

    @Autowired
    IPersonaService IpersonaService;

    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
        return IpersonaService.getPersona();
    }

    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        IpersonaService.savePersona(persona);
        return "La persona se creo correctamente";
    }

    @DeleteMapping("/personas/borrar/{Id}")
    public String deletePersona(@PathVariable Long Id) {
        IpersonaService.deletePersona(Id);
        return "Fue eliminada correctamente";
    }

    @PutMapping("/personas/editar/{Id}")
    public Persona editPersona(@PathVariable Long Id, 
            @RequestParam("nombre")String nuevoNombre,
            @RequestParam("apellido")String nuevoApellido,
            @RequestParam("img") String nuevaImg)
    {
        Persona persona = IpersonaService.findPersona(Id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImagen(nuevaImg);
        IpersonaService.savePersona(persona);
        return persona;
    }
}
