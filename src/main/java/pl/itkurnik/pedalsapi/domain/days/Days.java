package pl.itkurnik.pedalsapi.domain.days;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.itkurnik.pedalsapi.domain.month.Month;
import pl.itkurnik.pedalsapi.domain.season.Season;
import pl.itkurnik.pedalsapi.domain.weather.Weather;
import pl.itkurnik.pedalsapi.domain.weekday.Weekday;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "days")
@Getter
@Setter
@NoArgsConstructor
public class Days {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne(targetEntity = Season.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "season_id")
    private Season season;

    @Column(name = "year")
    private int year;

    @ManyToOne(targetEntity = Month.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "month_id")
    private Month month;

    @ManyToOne(targetEntity = Weekday.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "weekday_id")
    private Weekday weekday;

    @Column(name = "holiday")
    private boolean holiday;

    @Column(name = "workingday")
    private boolean workingday;

    @ManyToOne(targetEntity = Weather.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "weathersit_id", referencedColumnName = "id")
    private Weather weather;

    @Column(
            name = "temp",
            precision = 7,
            scale = 5
    )
    private BigDecimal temp;

    @Column(
            name = "atemp",
            precision = 7,
            scale = 5
    )
    private BigDecimal atemp;

    @Column(
            name = "hum",
            precision = 7,
            scale = 5
    )
    private BigDecimal hum;

    @Column(
            name = "windspeed",
            precision = 7,
            scale = 5
    )
    private BigDecimal windspeed;

    @Column(name = "casual")
    private int casual;

    @Column(name = "registered")
    private int registered;

    @Column(name = "total")
    private int total;

    public Days(Date date,
                Season season,
                int year,
                Month month,
                Weekday weekday,
                boolean holiday,
                boolean workingday,
                Weather weather,
                BigDecimal temp,
                BigDecimal atemp,
                BigDecimal hum,
                BigDecimal windspeed,
                int casual,
                int registered,
                int total) {
        this.date = date;
        this.season = season;
        this.year = year;
        this.month = month;
        this.weekday = weekday;
        this.holiday = holiday;
        this.workingday = workingday;
        this.weather = weather;
        this.temp = temp;
        this.atemp = atemp;
        this.hum = hum;
        this.windspeed = windspeed;
        this.casual = casual;
        this.registered = registered;
        this.total = total;
    }
}
