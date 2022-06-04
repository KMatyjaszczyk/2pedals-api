package pl.itkurnik.pedalsapi.domain.language;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.itkurnik.pedalsapi.domain.month.Month;
import pl.itkurnik.pedalsapi.domain.season.Season;
import pl.itkurnik.pedalsapi.domain.weather.Weather;
import pl.itkurnik.pedalsapi.domain.weekday.Weekday;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class LanguageChangeRequest {
    private List<Season> seasons;
    private List<Month> months;
    private List<Weather> weathers;
    private List<Weekday> weekdays;
}
