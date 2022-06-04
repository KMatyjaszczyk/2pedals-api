package pl.itkurnik.pedalsapi.domain.month;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.itkurnik.pedalsapi.domain.season.Season;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MonthService {
    private final MonthRepository monthRepository;

    public List<Month> findAll() {
        return monthRepository.findAll();
    }

    public Month findById(Long id) {
        return monthRepository.findById(id).orElseThrow(() -> new RuntimeException("Month not found"));
    }

    public void save(Month month) {
        monthRepository.save(month);
    }

    public void deleteById(Long id) {
        monthRepository.deleteById(id);
    }

    public void changeLanguage(List<Month> months) {
        validateMonthsCompatibility(months);

        monthRepository.saveAll(months);
    }

    private void validateMonthsCompatibility(List<Month> months) {
        List<Month> allMonths = findAll();
        boolean monthsHaveTheSameSizes = months.size() == allMonths.size();
        if (!monthsHaveTheSameSizes) {
            throw new RuntimeException("Months lists have different numbers of days");
        }

        List<Long> monthsIds = months.stream().map(Month::getId).collect(Collectors.toList());
        boolean monthsAreMatching = allMonths.stream().allMatch(month -> monthsIds.contains(month.getId()));
        if (!monthsAreMatching) {
            throw new RuntimeException("Months have incompatible identifiers");
        }
    }
}
