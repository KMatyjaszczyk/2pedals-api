package pl.itkurnik.pedalsapi.domain.hours.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoursStatisticsDataDto {
    private Map<Integer, SumStatisticsResultDto> sumHours;
    private Map<Integer, AverageStatisticsResultDto> avgHours;
}
