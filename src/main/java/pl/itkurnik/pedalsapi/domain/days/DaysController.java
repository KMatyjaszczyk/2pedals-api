package pl.itkurnik.pedalsapi.domain.days;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/days")
@RequiredArgsConstructor
public class DaysController {
    private final DaysService daysService;

    @GetMapping
    public List<Days> findAll() {
        return daysService.findAll();
    }

    @GetMapping("/{id}")
    public Days findById(@PathVariable Long id) {
        return daysService.findById(id);
    }
}
