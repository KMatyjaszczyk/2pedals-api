package pl.itkurnik.pedalsapi.domain.days;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DaysService {
    private final DaysRepository daysRepository;

    public List<Days> findAll() {
        return daysRepository.findAll();
    }

    public Days findById(Long id) {
        return daysRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Days not found with id %d", id)));
    }
}
