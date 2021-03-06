package pl.itkurnik.pedalsapi.domain.days.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.itkurnik.pedalsapi.domain.common.AverageStatisticsResultDto;
import pl.itkurnik.pedalsapi.domain.common.SumStatisticsResultDto;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DaysStatisticsDataDto {
    private Map<String, SumStatisticsResultDto> sumDays;
    private Map<String, AverageStatisticsResultDto> avgDays;
}
