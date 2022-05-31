package pl.itkurnik.pedalsapi.domain.days.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DaysStatisticsDto {
    private List<String> menuItems;
    private List<String> titles;
    private DaysStatisticsDataDto data;
    private String name;
}
