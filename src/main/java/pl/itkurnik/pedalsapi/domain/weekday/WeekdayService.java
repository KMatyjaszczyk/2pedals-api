package pl.itkurnik.pedalsapi.domain.weekday;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeekdayService {
    private final WeekdayRepository weekdayRepository;

    public List<Weekday> findAll() {
        return weekdayRepository.findAll();
    }

    public Weekday findById(Long id) {
        return weekdayRepository.findById(id).orElseThrow(() -> new RuntimeException("Weekday not found"));
    }

    public void save(Weekday weekday) {
        weekdayRepository.save(weekday);
    }

    public void deleteById(Long id) {
        weekdayRepository.deleteById(id);
    }

    public void changeLanguage(List<Weekday> weekdays) {
        validateDaysCompatibility(weekdays);

        weekdayRepository.saveAll(weekdays);
    }

    private void validateDaysCompatibility(List<Weekday> weekdays) {
        List<Weekday> allWeekdays = findAll();
        boolean daysHaveTheSameSizes = weekdays.size() == allWeekdays.size();
        if (!daysHaveTheSameSizes) {
            throw new RuntimeException("Day lists have different numbers of days");
        }

        List<Long> weekdaysIds = weekdays.stream().map(Weekday::getId).collect(Collectors.toList());
        boolean daysAreMatching = allWeekdays.stream().allMatch(weekday -> weekdaysIds.contains(weekday.getId()));
        if (!daysAreMatching) {
            throw new RuntimeException("Days have incompatible identifiers");
        }
    }
}
