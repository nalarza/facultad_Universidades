package universidades.Nelson.Class;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_country",unique = true, nullable = false)
    private long id;
    private String name_country;

    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    private Set<Universities> universities = new HashSet<>();

    public Countries() {
    }

    public Countries(long id, String name_country, Set<Universities> universities) {
        this.id = id;
        this.name_country = name_country;
        this.universities = universities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_country() {
        return name_country;
    }

    public void setName_country(String name_country) {
        this.name_country = name_country;
    }

    public Set<Universities> getUniversities() {
        return universities;
    }

    public void setUniversities(Set<Universities> universities) {
        this.universities = universities;
        for (Universities university: universities){
            university.setCountry(this);
        }
    }
}
