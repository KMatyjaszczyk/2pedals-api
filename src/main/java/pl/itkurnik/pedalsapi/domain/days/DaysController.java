package pl.itkurnik.pedalsapi.domain.days;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itkurnik.pedalsapi.domain.days.dto.DaysStatisticsDataDto;
import pl.itkurnik.pedalsapi.domain.days.dto.DaysStatisticsDto;

import java.util.Arrays;
import java.util.Collections;
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

    @GetMapping("/statistics")
    public DaysStatisticsDto receiveStatistics() {
        DaysStatisticsDto response = new DaysStatisticsDto();
        response.setName("test name");
        response.setMenuItems(Collections.singletonList("test menu item"));
        response.setTitles(Arrays.asList("test", "title"));
        DaysStatisticsDataDto statistics = daysService.receiveCalculatedStatistics();
        response.setData(statistics);
        return response;
    }
}
