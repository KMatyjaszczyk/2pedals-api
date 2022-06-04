package pl.itkurnik.pedalsapi.domain.month;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonthService {
    private final MonthRepository monthRepository;

    public List<Month> findAll() {
        return monthRepository.findAll();
    }

    public Month findById(Long id) {
        return monthRepository.findById(id).orElseThrow(() -> new RuntimeException("Month not found"));
    }

    public void save(Month month) {
        monthRepository.save(month);
    }

    public void deleteById(Long id) {
        monthRepository.deleteById(id);
    }
}
