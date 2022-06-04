package pl.itkurnik.pedalsapi.domain.weekday;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weekdays")
@RequiredArgsConstructor
public class WeekdayController {
    private final WeekdayService weekdayService;

    @GetMapping
    public List<Weekday> findAll() {
        return weekdayService.findAll();
    }

    @GetMapping("/{id}")
    public Weekday findById(@PathVariable Long id) {
        return weekdayService.findById(id);
    }

    @PostMapping
    public void add(@RequestBody Weekday weekday) {
        weekdayService.save(weekday);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        weekdayService.deleteById(id);
    }
}
