package pl.itkurnik.pedalsapi.domain.weekday;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "weekday")
@Getter
@Setter
@NoArgsConstructor
public class Weekday {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 40)
    private String name;

    public Weekday(String name) {
        this.name = name;
    }
}
