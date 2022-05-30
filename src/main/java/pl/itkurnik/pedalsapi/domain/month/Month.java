package pl.itkurnik.pedalsapi.domain.month;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "month")
@Getter
@Setter
@NoArgsConstructor
public class Month {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    public Month(String name) {
        this.name = name;
    }
}
