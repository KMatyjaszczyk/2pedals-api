package pl.itkurnik.pedalsapi.domain.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
