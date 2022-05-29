package pl.itkurnik.pedalsapi.domain.season;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeasonService {
    private final SeasonRepository seasonRepository;

    public List<Season> findAll() {
        return seasonRepository.findAll();
    }

    public Season findById(Long id) {
        return seasonRepository.findById(id).orElseThrow(() -> new RuntimeException("Season not found"));
    }

    public void save(Season season) {
        seasonRepository.save(season);
    }

    public void deleteById(Long id) {
        seasonRepository.deleteById(id);
    }
}
