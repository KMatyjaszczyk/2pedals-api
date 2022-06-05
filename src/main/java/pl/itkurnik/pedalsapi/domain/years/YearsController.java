package pl.itkurnik.pedalsapi.domain.years;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itkurnik.pedalsapi.domain.common.PedalsConstants;
import pl.itkurnik.pedalsapi.domain.years.dto.YearsStatisticsDataDto;
import pl.itkurnik.pedalsapi.domain.years.dto.YearsStatisticsDto;

@RestController
@RequestMapping("/years")
@RequiredArgsConstructor
public class YearsController {
    private final YearsService yearsService;

    @GetMapping("/statistics")
    public YearsStatisticsDto receiveStatistics() {
        YearsStatisticsDto response = new YearsStatisticsDto();
        response.setName(PedalsConstants.YEARS_NAME);
        response.setMenuItems(PedalsConstants.MENU_ITEMS);
        response.setTitles(PedalsConstants.YEARS_TITLES);
        YearsStatisticsDataDto statistics = yearsService.receiveCalculatedStatistics();
        response.setData(statistics);
        return response;
    }
}
