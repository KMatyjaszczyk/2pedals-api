package pl.itkurnik.pedalsapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SumStatisticsResultDto {
    private int total;
    private int casual;
    private int registered;
}
