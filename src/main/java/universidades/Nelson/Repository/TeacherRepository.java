package universidades.Nelson.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universidades.Nelson.Class.Teacher;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
