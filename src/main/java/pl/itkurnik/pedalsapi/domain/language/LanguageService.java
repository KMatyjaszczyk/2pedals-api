package pl.itkurnik.pedalsapi.domain.language;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.itkurnik.pedalsapi.domain.month.MonthService;
import pl.itkurnik.pedalsapi.domain.season.SeasonService;
import pl.itkurnik.pedalsapi.domain.weather.WeatherService;
import pl.itkurnik.pedalsapi.domain.weekday.WeekdayService;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LanguageService {
    private final SeasonService seasonService;
    private final MonthService monthService;
    private final WeatherService weatherService;
    private final WeekdayService weekdayService;

    @Transactional
    public void changeLanguage(LanguageChangeRequest request) {
        seasonService.changeLanguage(request.getSeasons());
        monthService.changeLanguage(request.getMonths());
        weatherService.changeLanguage(request.getWeathers());
        weekdayService.changeLanguage(request.getWeekdays());
    }
}
