package pl.itkurnik.pedalsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AverageStatisticsResultDto {
    private double total;
    private double casual;
    private double registered;
}
