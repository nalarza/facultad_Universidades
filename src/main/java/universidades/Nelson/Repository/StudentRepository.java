package universidades.Nelson.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universidades.Nelson.Class.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
