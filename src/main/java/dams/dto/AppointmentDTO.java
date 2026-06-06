package dams.dto;

public record AppointmentDTO(
    Long appointmentId,
    String appointmentDate,
    String appointmentTime,
    PatientDTO patient,
    DentistDTO dentist
) {}
