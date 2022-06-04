package pl.itkurnik.pedalsapi.domain.season;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.itkurnik.pedalsapi.domain.weather.Weather;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void changeLanguage(List<Season> seasons) {
        validateSeasonsCompatibility(seasons);

        seasonRepository.saveAll(seasons);
    }

    private void validateSeasonsCompatibility(List<Season> seasons) {
        List<Season> allSeasons = findAll();
        boolean seasonsHaveTheSameSizes = seasons.size() == allSeasons.size();
        if (!seasonsHaveTheSameSizes) {
            throw new RuntimeException("Seasons lists have different numbers of days");
        }

        List<Long> seasonsIds = seasons.stream().map(Season::getId).collect(Collectors.toList());
        boolean seasonsAreMatching = allSeasons.stream().allMatch(season -> seasonsIds.contains(season.getId()));
        if (!seasonsAreMatching) {
            throw new RuntimeException("Seasons have incompatible identifiers");
        }
    }
}
