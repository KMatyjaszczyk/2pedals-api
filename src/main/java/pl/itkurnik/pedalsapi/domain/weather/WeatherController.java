package pl.itkurnik.pedalsapi.domain.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping
    public List<Weather> findAll() {
        return weatherService.findAll();
    }

    @GetMapping("/{id}")
    public Weather findById(@PathVariable Long id) {
        return weatherService.findById(id);
    }

    @PostMapping
    public void add(@RequestBody Weather weather) {
        weatherService.save(weather);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        weatherService.deleteById(id);
    }
}
