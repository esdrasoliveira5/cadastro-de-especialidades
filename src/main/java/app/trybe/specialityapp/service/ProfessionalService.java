package app.trybe.specialityapp.service;

import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.repository.ProfessionalRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Professional Service.
 */
@Service
public class ProfessionalService {

  @Autowired
  private ProfessionalRepository repository;

  public List<Professional> getAllProfessionals() {
    return repository.findAll();
  }

  public Professional createProfessional(Professional professional) {
    return repository.save(professional);
  }

  /**
   * Put.
   * 
   */
  public Professional editProfessional(Integer id, Professional professional) {
    Professional oldProfesional =
        repository.findById(id).orElseThrow(() -> new NoSuchElementException());
    oldProfesional.setName(professional.getName());
    oldProfesional.setSpeciality(professional.getName());
    Professional updated = repository.save(oldProfesional);
    return updated;
  }

  /**
   * Delete.
   * 
   */
  public void deleteProfessional(Integer id) {
    Professional professional =
        repository.findById(id).orElseThrow(() -> new NoSuchElementException());
    repository.deleteById(professional.getId());
  }

}
