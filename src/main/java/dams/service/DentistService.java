package dams.service;

import dams.dto.DentistDTO;
import java.util.Optional;

public interface DentistService {
    Optional<DentistDTO> getDentistById(Long id);
}
