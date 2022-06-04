package pl.itkurnik.pedalsapi.domain.years.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YearsStatisticsDto {
    private List<String> menuItems;
    private List<String> titles;
    private YearsStatisticsDataDto data;
    private String name;
}
