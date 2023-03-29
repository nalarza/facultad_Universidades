package universidades.Nelson.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import universidades.Nelson.Class.Country;
import universidades.Nelson.Class.Faculty;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
