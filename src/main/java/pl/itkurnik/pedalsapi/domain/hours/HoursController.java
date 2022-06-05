package pl.itkurnik.pedalsapi.domain.hours;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.itkurnik.pedalsapi.domain.common.PedalsConstants;
import pl.itkurnik.pedalsapi.domain.hours.dto.HoursStatisticsDataDto;
import pl.itkurnik.pedalsapi.domain.hours.dto.HoursStatisticsDto;

import java.util.*;

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

    @GetMapping("/statistics")
    public HoursStatisticsDto receiveStatistics() {
        HoursStatisticsDto response = new HoursStatisticsDto();
        response.setName(PedalsConstants.HOURS_NAME);
        response.setMenuItems(PedalsConstants.MENU_ITEMS);
        response.setTitles(PedalsConstants.HOURS_TITLES);
        HoursStatisticsDataDto statistics = hoursService.receiveCalculatedStatistics();
        response.setData(statistics);
        return response;
    }
}
