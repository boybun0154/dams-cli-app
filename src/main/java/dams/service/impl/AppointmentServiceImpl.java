package dams.service.impl;

import dams.dao.AppointmentDAO;
import dams.domain.Appointment;
import dams.dto.AppointmentDTO;
import dams.dto.DentistDTO;
import dams.dto.PatientDTO;
import dams.service.AppointmentService;
import dams.service.DentistService;
import dams.service.PatientService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentDAO appointmentDAO = new AppointmentDAO();
    private final PatientService patientService = new PatientServiceImpl();
    private final DentistService dentistService = new DentistServiceImpl();

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("h:mm a");

    @Override
    public List<AppointmentDTO> getAllAppointmentsSortedDesc() {
        List<Appointment> appointments = appointmentDAO.findAll();

        // Sort by Date and Time in descending order
        appointments.sort((a1, a2) -> {
            int dateComp = a2.getAppointmentDate().compareTo(a1.getAppointmentDate());
            if (dateComp != 0) {
                return dateComp;
            }
            return a2.getAppointmentTime().compareTo(a1.getAppointmentTime());
        });

        return appointments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getQuarterlyUpcomingAppointments(LocalDate currentDate) {
        List<Appointment> appointments = appointmentDAO.findAll();

        // Calculate next quarter and target year
        int currentMonth = currentDate.getMonthValue();
        int currentQuarter = (currentMonth - 1) / 3 + 1;
        int nextQuarter = currentQuarter + 1;
        int targetYear = currentDate.getYear();
        if (nextQuarter > 4) {
            nextQuarter = 1;
            targetYear += 1;
        }

        final int targetQuarter = nextQuarter;
        final int targetYr = targetYear;

        // Filter appointments that fall into the target year and next quarter
        List<Appointment> filtered = appointments.stream()
                .filter(a -> {
                    LocalDate apptDate = a.getAppointmentDate();
                    if (apptDate == null) return false;
                    int apptQuarter = (apptDate.getMonthValue() - 1) / 3 + 1;
                    return apptDate.getYear() == targetYr && apptQuarter == targetQuarter;
                }).sorted((a1, a2) -> {
                    int dateComp = a1.getAppointmentDate().compareTo(a2.getAppointmentDate());
                    if (dateComp != 0) {
                        return dateComp;
                    }
                    return a1.getAppointmentTime().compareTo(a2.getAppointmentTime());
                }).toList();

        // Sort by Date and Time in ascending order

        return filtered.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        if (appointment == null) {
            return null;
        }

        // Fetch DTOs by talking to PatientService and DentistService
        PatientDTO patientDTO = patientService.getPatientById(appointment.getPatientId()).orElse(null);
        DentistDTO dentistDTO = dentistService.getDentistById(appointment.getDentistId()).orElse(null);

        String dateStr = appointment.getAppointmentDate() != null ? 
                appointment.getAppointmentDate().format(DATE_FORMATTER) : null;
        String timeStr = appointment.getAppointmentTime() != null ? 
                appointment.getAppointmentTime().format(TIME_FORMATTER) : null;

        return new AppointmentDTO(
                appointment.getAppointmentId(),
                dateStr,
                timeStr,
                patientDTO,
                dentistDTO
        );
    }
}
