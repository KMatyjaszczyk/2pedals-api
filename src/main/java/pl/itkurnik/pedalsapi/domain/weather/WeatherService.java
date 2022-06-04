package pl.itkurnik.pedalsapi.domain.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.itkurnik.pedalsapi.domain.weekday.Weekday;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepository weatherRepository;

    public List<Weather> findAll() {
        return weatherRepository.findAll();
    }

    public Weather findById(Long id) {
        return weatherRepository.findById(id).orElseThrow(() -> new RuntimeException("Weather not found"));
    }

    public void save(Weather weather) {
        weatherRepository.save(weather);
    }

    public void deleteById(Long id) {
        weatherRepository.deleteById(id);
    }

    public void changeLanguage(List<Weather> weathers) {
        validateWeathersCompatibility(weathers);

        weatherRepository.saveAll(weathers);
    }

    private void validateWeathersCompatibility(List<Weather> weathers) {
        List<Weather> allWeathers = findAll();
        boolean weathersHaveTheSameSizes = weathers.size() == allWeathers.size();
        if (!weathersHaveTheSameSizes) {
            throw new RuntimeException("Weathers lists have different numbers of days");
        }

        List<Long> weathersIds = weathers.stream().map(Weather::getId).collect(Collectors.toList());
        boolean seasonsAreMatching = allWeathers.stream().allMatch(weather -> weathersIds.contains(weather.getId()));
        if (!seasonsAreMatching) {
            throw new RuntimeException("Weathers have incompatible identifiers");
        }
    }
}
