package pl.itkurnik.pedalsapi.domain.years.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.itkurnik.pedalsapi.domain.dto.AverageStatisticsResultDto;
import pl.itkurnik.pedalsapi.domain.dto.SumStatisticsResultDto;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YearsStatisticsDataDto {
    private Map<String, SumStatisticsResultDto> sumSeasons;
    private Map<String, AverageStatisticsResultDto> avgSeasons;
}
