package pl.itkurnik.pedalsapi.domain.days;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.itkurnik.pedalsapi.domain.days.dto.DaysStatisticsDataDto;
import pl.itkurnik.pedalsapi.domain.dto.AverageStatisticsResultDto;
import pl.itkurnik.pedalsapi.domain.dto.SumStatisticsResultDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DaysService {
    private final DaysRepository daysRepository;

    public List<Days> findAll() {
        return daysRepository.findAll();
    }

    public Days findById(Long id) {
        return daysRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Days not found with id %d", id)));
    }

    public DaysStatisticsDataDto receiveCalculatedStatistics() {
        List<Days> allDays = findAll();
        Map<String, List<Days>> dayNameToDays = allDays.stream().collect(Collectors.groupingBy(days -> days.getWeekday().getName()));
        Map<String, SumStatisticsResultDto> dayNamesToSums = receiveDayValuesToSums(dayNameToDays);
        Map<String, AverageStatisticsResultDto> dayNamesToAverages = receiveDayNamesToAverages(dayNameToDays);
        return new DaysStatisticsDataDto(dayNamesToSums, dayNamesToAverages);
    }

    @NonNull
    private Map<String, SumStatisticsResultDto> receiveDayValuesToSums(Map<String, List<Days>> dayNamesToDays) {
        Map<String, SumStatisticsResultDto> dayValuesToSums = new HashMap<>();
        for (Map.Entry<String, List<Days>> entry : dayNamesToDays.entrySet()) {
            String dayName = entry.getKey();
            List<Days> daysData = entry.getValue();

            int totalSum = daysData.stream().mapToInt(Days::getTotal).sum();
            int casualSum = daysData.stream().mapToInt(Days::getCasual).sum();
            int registeredSum = daysData.stream().mapToInt(Days::getRegistered).sum();

            dayValuesToSums.put(dayName, new SumStatisticsResultDto(totalSum, casualSum, registeredSum));
        }
        return dayValuesToSums;
    }

    @NonNull
    private Map<String, AverageStatisticsResultDto> receiveDayNamesToAverages(Map<String, List<Days>> dayNameToHours) {
        Map<String, AverageStatisticsResultDto> hourValuesToAverages = new HashMap<>();
        for (Map.Entry<String, List<Days>> entry : dayNameToHours.entrySet()) {
            String dayName = entry.getKey();
            List<Days> daysData = entry.getValue();

            double totalAverage = daysData.stream().mapToInt(Days::getTotal).average().orElseThrow(() -> new RuntimeException("Error during average"));
            double casualAverage = daysData.stream().mapToInt(Days::getCasual).average().orElseThrow(() -> new RuntimeException("Error during average"));
            double registeredAverage = daysData.stream().mapToInt(Days::getRegistered).average().orElseThrow(() -> new RuntimeException("Error during average"));

            hourValuesToAverages.put(dayName, new AverageStatisticsResultDto(totalAverage, casualAverage, registeredAverage));
        }
        return hourValuesToAverages;
    }
}
