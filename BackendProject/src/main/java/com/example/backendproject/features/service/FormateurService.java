package com.example.backendproject.features.service;

import com.example.backendproject.features.model.Formateur;
import com.example.backendproject.features.repo.FormateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class FormateurService {
    @Autowired
    private FormateurRepo formateurRepo;

    public Formateur addFormateur(Formateur formateur){
     formateur.setFormateurCode(UUID.randomUUID().toString());
     return formateurRepo.save(formateur);
    }

    public List<Formateur> findAllForamteur(){
    return formateurRepo.findAll();
    }

    public Formateur updateformateur(Formateur formateur){
    return formateurRepo.save(formateur);
    }

//    public Formateur findFormateurById(Long id){
//     return formateurRepo.findFormateurById(id).orElseThrow(() ->new UserNotFoundException("User by id " + id+ "was note found"));
//    }

    public void deleteFormateur(Long id){
    formateurRepo.deleteFormateurById(id);
    }
}
