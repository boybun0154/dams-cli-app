package dams.service.impl;

import dams.dao.PatientDAO;
import dams.domain.Patient;
import dams.dto.PatientDTO;
import dams.service.PatientService;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class PatientServiceImpl implements PatientService {

    private final PatientDAO patientDAO = new PatientDAO();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public Optional<PatientDTO> getPatientById(Long id) {
        return patientDAO.findById(id).map(this::convertToDTO);
    }

    private PatientDTO convertToDTO(Patient patient) {
        if (patient == null) {
            return null;
        }

        int age = 0;
        if (patient.getDateOfBirth() != null) {
            age = Period.between(patient.getDateOfBirth(), LocalDate.now()).getYears();
        }

        String dobStr = patient.getDateOfBirth() != null ? 
                patient.getDateOfBirth().format(DATE_FORMATTER) : null;

        return new PatientDTO(
                patient.getId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getPhoneNumber(),
                dobStr,
                age
        );
    }
}
