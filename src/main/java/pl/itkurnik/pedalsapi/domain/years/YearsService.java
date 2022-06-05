package pl.itkurnik.pedalsapi.domain.years;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.itkurnik.pedalsapi.domain.days.Days;
import pl.itkurnik.pedalsapi.domain.days.DaysService;
import pl.itkurnik.pedalsapi.domain.common.AverageStatisticsResultDto;
import pl.itkurnik.pedalsapi.domain.common.SumStatisticsResultDto;
import pl.itkurnik.pedalsapi.domain.years.dto.YearsStatisticsDataDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class YearsService {
    private final DaysService daysService;

    public YearsStatisticsDataDto receiveCalculatedStatistics() {
        List<Days> allDays = daysService.findAll();
        Map<String, List<Days>> seasonNamesToDays = allDays.stream().collect(Collectors.groupingBy(days -> days.getSeason().getName()));
        Map<String, SumStatisticsResultDto> seasonNamesToSums = receiveSeasonNamesToSums(seasonNamesToDays);
        Map<String, AverageStatisticsResultDto> seasonNamesToAverages = receiveSeasonNamesToAverages(seasonNamesToDays);
        return new YearsStatisticsDataDto(seasonNamesToSums, seasonNamesToAverages);
    }

    @NonNull
    private Map<String, SumStatisticsResultDto> receiveSeasonNamesToSums(Map<String, List<Days>> seasonNamesToDays) {
        Map<String, SumStatisticsResultDto> seasonNamesToSums = new HashMap<>();
        for (Map.Entry<String, List<Days>> entry : seasonNamesToDays.entrySet()) {
            String seasonName = entry.getKey();
            List<Days> daysData = entry.getValue();

            int totalSum = daysData.stream().mapToInt(Days::getTotal).sum();
            int casualSum = daysData.stream().mapToInt(Days::getCasual).sum();
            int registeredSum = daysData.stream().mapToInt(Days::getRegistered).sum();

            seasonNamesToSums.put(seasonName, new SumStatisticsResultDto(totalSum, casualSum, registeredSum));
        }
        return seasonNamesToSums;
    }

    @NonNull
    private Map<String, AverageStatisticsResultDto> receiveSeasonNamesToAverages(Map<String, List<Days>> seasonNamesToDays) {
        Map<String, AverageStatisticsResultDto> seasonNamesToAverages = new HashMap<>();
        for (Map.Entry<String, List<Days>> entry : seasonNamesToDays.entrySet()) {
            String seasonName = entry.getKey();
            List<Days> daysData = entry.getValue();

            double totalAverage = daysData.stream().mapToInt(Days::getTotal).average().orElseThrow(() -> new RuntimeException("Error during average"));
            double casualAverage = daysData.stream().mapToInt(Days::getCasual).average().orElseThrow(() -> new RuntimeException("Error during average"));
            double registeredAverage = daysData.stream().mapToInt(Days::getRegistered).average().orElseThrow(() -> new RuntimeException("Error during average"));

            seasonNamesToAverages.put(seasonName, new AverageStatisticsResultDto(totalAverage, casualAverage, registeredAverage));
        }
        return seasonNamesToAverages;
    }
}
