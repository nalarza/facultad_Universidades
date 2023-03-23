package universidades.Nelson.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universidades.Nelson.Class.Matter;
@Repository
public interface MatterRepository extends JpaRepository<Matter,Long> {
}
