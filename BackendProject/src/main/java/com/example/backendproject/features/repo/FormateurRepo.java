package com.example.backendproject.features.repo;

import com.example.backendproject.features.model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepo extends JpaRepository<Formateur, Long> {

    void deleteFormateurById(Long id);
}
