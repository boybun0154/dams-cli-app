package dams.dao;

import dams.domain.Patient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientDAO {
    private static final List<Patient> patients = new ArrayList<>();

    static {
        // Initial Patients loaded from existing dataset
        patients.add(new Patient(1L, "John", "Smith", "(641) 001-1234", LocalDate.of(1987, 1, 19)));
        patients.add(new Patient(2L, "Anna", "Jones", "(319) 716-1987", LocalDate.of(2001, 7, 26)));
        patients.add(new Patient(3L, "Carlos", "Jimenez", "(319) 098-7711", LocalDate.of(1969, 11, 5)));
        patients.add(new Patient(4L, "Albert", "Einstein", "(641) 119-6142", LocalDate.of(1955, 12, 28)));
    }

    public List<Patient> findAll() {
        return new ArrayList<>(patients);
    }

    public Optional<Patient> findById(Long id) {
        return patients.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public void save(Patient patient) {
        patients.add(patient);
    }
}
