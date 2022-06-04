package pl.itkurnik.pedalsapi.domain.weekday;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeekdayService {
    private final WeekdayRepository weekdayRepository;

    public List<Weekday> findAll() {
        return weekdayRepository.findAll();
    }

    public Weekday findById(Long id) {
        return weekdayRepository.findById(id).orElseThrow(() -> new RuntimeException("Weekday not found"));
    }

    public void save(Weekday weekday) {
        weekdayRepository.save(weekday);
    }

    public void deleteById(Long id) {
        weekdayRepository.deleteById(id);
    }
}
