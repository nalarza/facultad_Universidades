package universidades.Nelson.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universidades.Nelson.Class.Career;
@Repository
public interface CareerRepository extends JpaRepository <Career,Long> {
}
