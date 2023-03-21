package universidades.Nelson.Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_city",unique = true,nullable = false)
    private Long id ;
    private String nombre_del_pais;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_country")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Country country;

    @OneToOne(mappedBy = "city",cascade = CascadeType.ALL)
    private University university;

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    public City() {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_del_pais() {
        return nombre_del_pais;
    }

    public void setNombre_del_pais(String nombre_del_pais) {
        this.nombre_del_pais = nombre_del_pais;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
        for (Student student: students){
            student.setCity(this);
        }
    }
}
