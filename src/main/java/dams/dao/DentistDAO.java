package dams.dao;

import dams.domain.Dentist;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DentistDAO {
    private static final List<Dentist> dentists = new ArrayList<>();

    static {
        // Mock dentist data to associate with appointments
        dentists.add(new Dentist(1L, "Richard", "Harris", "(319) 555-1234", "Orthodontist"));
        dentists.add(new Dentist(2L, "Susan", "Sarandon", "(641) 555-5678", "Pediatric Dentist"));
    }

    public List<Dentist> findAll() {
        return new ArrayList<>(dentists);
    }

    public Optional<Dentist> findById(Long id) {
        return dentists.stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public void save(Dentist dentist) {
        dentists.add(dentist);
    }
}
