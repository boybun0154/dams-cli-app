package dams.dto;

public record PatientDTO(
    Long id,
    String firstName,
    String lastName,
    String phoneNumber,
    String dateOfBirth,
    int age
) {}
