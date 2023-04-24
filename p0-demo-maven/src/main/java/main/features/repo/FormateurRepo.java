package main.features.repo;

import main.features.model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepo extends JpaRepository<Formateur, Long> {

	
}
