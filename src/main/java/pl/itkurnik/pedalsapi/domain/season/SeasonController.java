package pl.itkurnik.pedalsapi.domain.season;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seasons")
@RequiredArgsConstructor
public class SeasonController {
    private final SeasonService seasonService;

    @GetMapping
    public List<Season> findAll() {
        return seasonService.findAll();
    }

    @GetMapping("/{id}")
    public Season findById(@PathVariable Long id) {
        return seasonService.findById(id);
    }

    @PostMapping
    public void add(@RequestBody Season season) {
        seasonService.save(season);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        seasonService.deleteById(id);
    }
}
