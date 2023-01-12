
package com.example.demo.Controller;

import com.example.demo.Dto.DtoExperiencia;
import com.example.demo.Entity.Experiencia;
import com.example.demo.Security.Controller.Mensaje;
import com.example.demo.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "https://localhost:4200")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    @GetMapping("/lista")
    public ResponseEntity <List <Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        if (sExperiencia.existByNombreE(dtoExp.getNombreE()))
            return new ResponseEntity (new Mensaje("Esa experiencia existe"),HttpStatus.BAD_REQUEST);
        Experiencia Exp = new Experiencia(dtoExp.getNombreE(),dtoExp.getDescripcionE());
        sExperiencia.save(Exp);
        return new ResponseEntity(new Mensaje("Experiencia agregada"),HttpStatus.BAD_REQUEST);
        
        
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody DtoExperiencia dtoExp){
        if(!sExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("el ID no existe"), HttpStatus.BAD_REQUEST);
        if(sExperiencia.existByNombreE(dtoExp.getNombreE()) && sExperiencia.getByNombreE(dtoExp.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje("esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        Experiencia Exp = sExperiencia.getOne(id).get();
        Exp.setNombreE(dtoExp.getNombreE());
        Exp.setDescripcionE(dtoExp.getDescripcionE());
        sExperiencia.save(Exp);
              return new ResponseEntity(new Mensaje("experiencia actualizada"), HttpStatus.OK);
      
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
    
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existById(id))//capaz es existsById
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
