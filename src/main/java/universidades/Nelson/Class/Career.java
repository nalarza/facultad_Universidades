package universidades.Nelson.Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "career")
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( unique = true, nullable = false)
    private long id_career;
    private String name_career;
    private String structure_career;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_faculty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Faculty faculty;

    @OneToMany(mappedBy = "career",cascade = CascadeType.ALL)
    private Set<Classroom> classrooms = new HashSet<>();

    @OneToOne(mappedBy = "career",cascade = CascadeType.ALL)
    private Student student;

    public Career() {
    }

    public Career(long id_career, String name_career, String structure_career,
                  Faculty faculty, Set<Classroom> classrooms, Student student) {
        this.id_career = id_career;
        this.name_career = name_career;
        this.structure_career = structure_career;
        this.faculty = faculty;
        this.classrooms = classrooms;
        this.student = student;
    }

    public long getId_career() {
        return id_career;
    }

    public void setId_career(long id_career) {
        this.id_career = id_career;
    }

    public String getName_career() {
        return name_career;
    }

    public void setName_career(String name_career) {
        this.name_career = name_career;
    }

    public String getStructure_career() {
        return structure_career;
    }

    public void setStructure_career(String structure_career) {
        this.structure_career = structure_career;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Set<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Set<Classroom> classrooms) {
        this.classrooms = classrooms;
        for (Classroom classroom:classrooms){
            classroom.setCareer(this);
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
