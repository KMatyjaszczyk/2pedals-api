package pl.itkurnik.pedalsapi.domain.years;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itkurnik.pedalsapi.domain.years.dto.YearsStatisticsDataDto;
import pl.itkurnik.pedalsapi.domain.years.dto.YearsStatisticsDto;

import java.util.Arrays;
import java.util.Collections;

@RestController
@RequestMapping("/years")
@RequiredArgsConstructor
public class YearsController {
    private final YearsService yearsService;

    @GetMapping("/statistics")
    public YearsStatisticsDto receiveStatistics() {
        YearsStatisticsDto response = new YearsStatisticsDto();
        response.setName("test name");
        response.setMenuItems(Collections.singletonList("test menu item"));
        response.setTitles(Arrays.asList("test", "title"));
        YearsStatisticsDataDto statistics = yearsService.receiveCalculatedStatistics();
        response.setData(statistics);
        return response;
    }
}
