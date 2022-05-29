package pl.itkurnik.pedalsapi.domain.season;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(
        name = "seasons",
        uniqueConstraints = { @UniqueConstraint(name = "seasons_name_unique", columnNames = "name") }
)
@Getter
@Setter
@NoArgsConstructor
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    public Season(String name) {
        this.name = name;
    }
}
