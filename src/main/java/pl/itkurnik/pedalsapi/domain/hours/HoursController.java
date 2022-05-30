package pl.itkurnik.pedalsapi.domain.hours;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hours")
@RequiredArgsConstructor
public class HoursController {
    private final HoursService hoursService;

    @GetMapping
    public List<Hours> findAll() {
        return hoursService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hours> findById(@PathVariable Long id) {
        Hours hours = hoursService.findById(id);
        return ResponseEntity.ok(hours);
    }
}
