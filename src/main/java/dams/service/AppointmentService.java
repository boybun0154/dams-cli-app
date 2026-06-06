package dams.service;

import dams.dto.AppointmentDTO;
import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    List<AppointmentDTO> getAllAppointmentsSortedDesc();
    List<AppointmentDTO> getQuarterlyUpcomingAppointments(LocalDate currentDate);
}
