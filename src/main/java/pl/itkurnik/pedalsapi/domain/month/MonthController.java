package pl.itkurnik.pedalsapi.domain.month;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/months")
@RequiredArgsConstructor
public class MonthController {
    private final MonthService monthService;

    @GetMapping
    public List<Month> findAll() {
        return monthService.findAll();
    }

    @GetMapping("/{id}")
    public Month findById(@PathVariable Long id) {
        return monthService.findById(id);
    }

    @PostMapping
    public void add(@RequestBody Month month) {
        monthService.save(month);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        monthService.deleteById(id);
    }
}
