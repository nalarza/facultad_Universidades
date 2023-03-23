package universidades.Nelson.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universidades.Nelson.Class.University;
@Repository
public interface UniversityRepository extends JpaRepository<University,Long> {
}
