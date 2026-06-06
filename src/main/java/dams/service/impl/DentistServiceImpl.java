package dams.service.impl;

import dams.dao.DentistDAO;
import dams.domain.Dentist;
import dams.dto.DentistDTO;
import dams.service.DentistService;

import java.util.Optional;

public class DentistServiceImpl implements DentistService {

    private final DentistDAO dentistDAO = new DentistDAO();

    @Override
    public Optional<DentistDTO> getDentistById(Long id) {
        return dentistDAO.findById(id).map(this::convertToDTO);
    }

    private DentistDTO convertToDTO(Dentist dentist) {
        if (dentist == null) {
            return null;
        }

        return new DentistDTO(
                dentist.getId(),
                dentist.getFirstName(),
                dentist.getLastName(),
                dentist.getPhoneNumber(),
                dentist.getSpecialization()
        );
    }
}
