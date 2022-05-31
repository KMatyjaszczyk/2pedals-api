package pl.itkurnik.pedalsapi.domain.hours;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.itkurnik.pedalsapi.domain.hours.dto.AverageStatisticsResultDto;
import pl.itkurnik.pedalsapi.domain.hours.dto.HoursStatisticsDataDto;
import pl.itkurnik.pedalsapi.domain.hours.dto.SumStatisticsResultDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HoursService {
    private final HoursRepository hoursRepository;

    public List<Hours> findAll() {
        return hoursRepository.findAll();
    }

    public Hours findById(Long id) {
        return hoursRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Hours not found with id %d", id)));
    }

    public HoursStatisticsDataDto receiveCalculatedStatistics() {
        List<Hours> allHours = findAll();
        Map<Integer, List<Hours>> hourValueToHours = allHours.stream().collect(Collectors.groupingBy(Hours::getHour));
        Map<Integer, SumStatisticsResultDto> hourValuesToSums = receiveHourValuesToSums(hourValueToHours);
        Map<Integer, AverageStatisticsResultDto> hourValuesToAverages = receiveHourValuesToAverages(hourValueToHours);
        return new HoursStatisticsDataDto(hourValuesToSums, hourValuesToAverages);
    }

    @NonNull
    private Map<Integer, SumStatisticsResultDto> receiveHourValuesToSums(Map<Integer, List<Hours>> hourValueToHours) {
        Map<Integer, SumStatisticsResultDto> hourValuesToSums = new HashMap<>();
        for (Map.Entry<Integer, List<Hours>> entry : hourValueToHours.entrySet()) {
            Integer hourValue = entry.getKey();
            List<Hours> hoursData = entry.getValue();

            int totalSum = hoursData.stream().mapToInt(Hours::getTotal).sum();
            int casualSum = hoursData.stream().mapToInt(Hours::getCasual).sum();
            int registeredSum = hoursData.stream().mapToInt(Hours::getRegistered).sum();

            hourValuesToSums.put(hourValue, new SumStatisticsResultDto(totalSum, casualSum, registeredSum));
        }
        return hourValuesToSums;
    }

    @NonNull
    private Map<Integer, AverageStatisticsResultDto> receiveHourValuesToAverages(Map<Integer, List<Hours>> hourValueToHours) {
        Map<Integer, AverageStatisticsResultDto> hourValuesToAverages = new HashMap<>();
        for (Map.Entry<Integer, List<Hours>> entry : hourValueToHours.entrySet()) {
            Integer hourValue = entry.getKey();
            List<Hours> hoursData = entry.getValue();

            double totalAverage = hoursData.stream().mapToInt(Hours::getTotal).average().orElseThrow(() -> new RuntimeException("Error during average"));
            double casualAverage = hoursData.stream().mapToInt(Hours::getCasual).average().orElseThrow(() -> new RuntimeException("Error during average"));
            double registeredAverage = hoursData.stream().mapToInt(Hours::getRegistered).average().orElseThrow(() -> new RuntimeException("Error during average"));

            hourValuesToAverages.put(hourValue, new AverageStatisticsResultDto(totalAverage, casualAverage, registeredAverage));
        }
        return hourValuesToAverages;
    }
}
