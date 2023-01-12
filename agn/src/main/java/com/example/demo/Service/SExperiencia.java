/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Service;

import com.example.demo.Entity.Experiencia;
import com.example.demo.Repository.iRExperiencia;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
@Transactional 

public class SExperiencia {
    @Autowired
    iRExperiencia irExperiencia;
    public List<Experiencia>list(){
        return irExperiencia.findAll();
    }
    public Optional<Experiencia> getOne (int id){
        return irExperiencia.findById(id);
    }
    public Optional<Experiencia> getByNombreE(String nombreE){
        return irExperiencia.finByNombreE(nombreE);
    }
    public void save(Experiencia expe){
        irExperiencia.save(expe);
        
    }
    public void delete(int id){
        irExperiencia.deleteById(id);
    }
    
    public boolean existById (int id){
        return irExperiencia.existsById(id);
    }
    public boolean existByNombreE (String nombreE){
        return irExperiencia.existByNombreE(nombreE);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
