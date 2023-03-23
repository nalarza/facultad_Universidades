package universidades.Nelson.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universidades.Nelson.Class.Classroom;
@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
}
