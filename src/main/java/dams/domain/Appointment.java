package dams.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private Long appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Long patientId;
    private Long dentistId;

    public Appointment() {}

    public Appointment(Long appointmentId, LocalDate appointmentDate, LocalTime appointmentTime, Long patientId, Long dentistId) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.patientId = patientId;
        this.dentistId = dentistId;
    }

    public Long getAppointmentId() { return appointmentId; }
    public void setAppointmentId(Long appointmentId) { this.appointmentId = appointmentId; }

    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }

    public LocalTime getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(LocalTime appointmentTime) { this.appointmentTime = appointmentTime; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public Long getDentistId() { return dentistId; }
    public void setDentistId(Long dentistId) { this.dentistId = dentistId; }
}
