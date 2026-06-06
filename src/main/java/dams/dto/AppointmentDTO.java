package dams.dto;

public record AppointmentDTO(
    Long id,
    String appointmentDate,
    String appointmentTime,
    PatientDTO patient,
    DentistDTO dentist
) {}
