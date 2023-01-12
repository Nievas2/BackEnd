/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Repository;

import com.example.demo.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRExperiencia  extends JpaRepository<Experiencia, Integer>{
     public Optional<Experiencia> finByNombreE(String nombreE);
     public boolean existByNombreE(String nombreE);
     
     
     
     
     
     
     
     
     
}
