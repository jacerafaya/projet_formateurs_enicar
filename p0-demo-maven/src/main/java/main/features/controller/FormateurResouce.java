package main.features.controller;
import main.features.model.Formateur;
import main.features.service.FormateurService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FormateurResouce {
	
	@Autowired
    private final FormateurService formateurService = new FormateurService();

    @GetMapping(value = "/all")
    public List<Formateur> getAllForamteur () {
        List<Formateur> formateurs = formateurService.getAllForamteur();
        return formateurs;
    }

    @PostMapping("/add")
    public ResponseEntity<Formateur> addFormateur(@RequestBody Formateur formateur){
        Formateur newformateur = formateurService.addFormateur(formateur);
        return new ResponseEntity<>(newformateur, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Formateur> updateFormateur(@RequestBody Formateur formateur){
        Formateur updateformateur = formateurService.updateformateur(formateur);
        return new ResponseEntity<>(updateformateur, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Formateur> deleteFormateur(@PathVariable("id") Long id  ){
          formateurService.deleteFormateur(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


