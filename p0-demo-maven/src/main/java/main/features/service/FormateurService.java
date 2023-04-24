package main.features.service;

import main.features.model.Formateur;
import main.features.repo.FormateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FormateurService {
    @Autowired
    private FormateurRepo formateurRepo;

    public Formateur addFormateur(@RequestBody Formateur formateur){
     return formateurRepo.save(formateur);
    }

    public List<Formateur> getAllForamteur(){
    return formateurRepo.findAll();
    }

    public Formateur updateformateur(Formateur formateur){
    return formateurRepo.save(formateur);
    }


    public void deleteFormateur(Long id){
    formateurRepo.deleteById(id);
    }
}
