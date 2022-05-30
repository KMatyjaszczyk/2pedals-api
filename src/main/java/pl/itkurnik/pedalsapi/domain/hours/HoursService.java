package pl.itkurnik.pedalsapi.domain.hours;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HoursService {
    private final HoursRepository hoursRepository;

    public List<Hours> findAll() {
        return hoursRepository.findAll();
    }

    public Hours findById(Long id) {
        return hoursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Hours not found with id %d", id)));
    }
}
