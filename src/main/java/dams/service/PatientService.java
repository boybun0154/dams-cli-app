package dams.service;

import dams.dto.PatientDTO;
import java.util.Optional;

public interface PatientService {
    Optional<PatientDTO> getPatientById(Long id);
}
