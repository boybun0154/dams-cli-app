package dams.dao;

import dams.domain.Appointment;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentDAO {
    private static final List<Appointment> appointments = new ArrayList<>();

    static {
        // Appointments loaded directly using patientId and dentistId
        // Appointment 1: 2026-2-28 at 10:05 AM (Patient 1, Dentist 1)
        appointments.add(new Appointment(1L, LocalDate.of(2026, 2, 28), LocalTime.of(10, 5), 1L, 1L));
        // Appointment 2: 2025-12-31 at 1:45 PM (Patient 2, Dentist 2)
        appointments.add(new Appointment(2L, LocalDate.of(2025, 12, 31), LocalTime.of(13, 45), 2L, 2L));
        // Appointment 3: 2027-5-4 at 2:00 PM (Patient 3, Dentist 1)
        appointments.add(new Appointment(3L, LocalDate.of(2027, 5, 4), LocalTime.of(14, 0), 3L, 1L));
        // Appointment 4: 2026-9-16 at 11:15 AM (Patient 4, Dentist 2)
        appointments.add(new Appointment(4L, LocalDate.of(2026, 9, 16), LocalTime.of(11, 15), 4L, 2L));
    }

    public List<Appointment> findAll() {
        return new ArrayList<>(appointments);
    }

    public Optional<Appointment> findById(Long id) {
        return appointments.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    public void save(Appointment appointment) {
        appointments.add(appointment);
    }
}
