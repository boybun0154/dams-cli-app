package dams.dto;

public record DentistDTO(
    Long id,
    String firstName,
    String lastName,
    String phoneNumber,
    String specialization
) {}
