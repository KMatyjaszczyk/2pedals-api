package pl.itkurnik.pedalsapi.domain.days;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaysRepository extends JpaRepository<Days, Long> {
}
