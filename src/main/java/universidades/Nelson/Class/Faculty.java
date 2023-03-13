package universidades.Nelson.Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_faculty;
    private String name_faculty;
    private String information_faculty;

    @ManyToOne(fetch =FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_university")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private University university ;

    @OneToMany(mappedBy ="faculty",cascade = CascadeType.ALL)
    private Set<Career> careers = new HashSet<>();

    public Faculty() {
    }


    public long getId_faculty() {
        return id_faculty;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public void setId_faculty(long id_faculty) {
        this.id_faculty = id_faculty;
    }

    public String getName_faculty() {
        return name_faculty;
    }

    public void setName_faculty(String name_faculty) {
        this.name_faculty = name_faculty;
    }

    public String getInformation_faculty() {
        return information_faculty;
    }

    public void setInformation_faculty(String information_faculty) {
        this.information_faculty = information_faculty;
    }
}
