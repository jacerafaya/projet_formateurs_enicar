package com.example.backendproject.features.controller;

import com.example.backendproject.features.model.Formateur;
import com.example.backendproject.features.service.FormateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/formateur")
public class FormateurResouce {
    private final FormateurService formateurService;


    @GetMapping(value = "/all")
    public List<Formateur> getAllForamteur () {
        List<Formateur> formateurs = formateurService.findAllForamteur();
        return formateurs;
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<Formateur> getFormateurById (@PathVariable("id") Long id) {
////        Formateur formateur = formateurService.findFormateurById(id);
//        return new ResponseEntity<>(formateur, HttpStatus.OK);
//    }

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


