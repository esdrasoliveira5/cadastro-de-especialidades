package app.trybe.specialityapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.repository.ProfessionalRepository;

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
}
