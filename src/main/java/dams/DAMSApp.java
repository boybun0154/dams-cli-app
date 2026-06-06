package dams;

import dams.dto.AppointmentDTO;
import dams.service.AppointmentService;
import dams.service.impl.AppointmentServiceImpl;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class DAMSApp {
    public static void main(String[] args) {
        AppointmentService appointmentService = new AppointmentServiceImpl();
        ObjectMapper mapper = new ObjectMapper();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("============================================================");
            System.out.println("          Dentist Appointment Management System (DAMS)      ");
            System.out.println("============================================================");
            System.out.println("1. Display all booked appointments (Sorted Descending)");
            System.out.println("2. Display quarterly upcoming appointments (Sorted Ascending)");
            System.out.println("3. Exit");
            System.out.println("============================================================");
            System.out.print("Please enter your choice (1-3): ");

            String input = scanner.nextLine().trim();

            if (input.equals("1")) {
                List<AppointmentDTO> allAppointments = appointmentService.getAllAppointmentsSortedDesc();
                System.out.println("\n--- All Booked Appointments (Sorted Descending) ---");
                try {
                    String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(allAppointments);
                    System.out.println(jsonOutput);
                } catch (Exception e) {
                    System.err.println("Error serializing all appointments to JSON: " + e.getMessage());
                }
                System.out.println();
            } else if (input.equals("2")) {
                LocalDate currentDate = LocalDate.now();
                List<AppointmentDTO> quarterlyAppointments = appointmentService.getQuarterlyUpcomingAppointments(currentDate);
                System.out.println("\n--- Quarterly Upcoming Appointments (Sorted Ascending) ---");
                try {
                    String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(quarterlyAppointments);
                    System.out.println(jsonOutput);
                } catch (Exception e) {
                    System.err.println("Error serializing quarterly appointments to JSON: " + e.getMessage());
                }
                System.out.println();
            } else if (input.equals("3")) {
                System.out.println("\nThank you for using DAMS. Exiting...");
                break;
            } else {
                System.out.println("\n[ERROR] Invalid choice. Please enter a number between 1 and 3.\n");
            }
        }
        scanner.close();
    }
}
