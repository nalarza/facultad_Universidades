package universidades.Nelson.Class;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_faculty;
    private String name_faculty;
    private String information_faculty;

    public Faculty() {
    }

    public Faculty(long id_faculty, String name_faculty, String information_faculty) {
        this.id_faculty = id_faculty;
        this.name_faculty = name_faculty;
        this.information_faculty = information_faculty;
    }

    public long getId_faculty() {
        return id_faculty;
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
