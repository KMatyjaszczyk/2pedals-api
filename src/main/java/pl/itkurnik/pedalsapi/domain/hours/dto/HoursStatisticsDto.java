package pl.itkurnik.pedalsapi.domain.hours.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoursStatisticsDto {
    private List<String> menuItems;
    private List<String> titles;
    private HoursStatisticsDataDto data;
    private String name;
}
