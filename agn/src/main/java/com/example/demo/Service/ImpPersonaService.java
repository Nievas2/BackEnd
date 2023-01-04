/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Entity.Persona;
import com.example.demo.Interface.IPersonaService;
import com.example.demo.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
/**
 *
 * @author User
 */
public class ImpPersonaService implements IPersonaService{
    @Autowired  IPersonaRepository IpersonaRepository;
    @Override
    public List<Persona> getPersona() {
        List<Persona> personas = IpersonaRepository.findAll();
        return personas;
    }   

    @Override
    public void savePersona(Persona persona) {
        IpersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long Id) {
        IpersonaRepository.deleteById(Id);
    }

    @Override
    public Persona findPersona(Long Id) {
        Persona persona = IpersonaRepository.findById(Id).orElse(null);
        return persona;
        
    }
    
}
