package universidades.Nelson.Class;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_country",unique = true, nullable = false)
    private long id;
    private String name_country;

    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    private Set<City> cities = new HashSet<>();

    @OneToOne(mappedBy = "country",cascade = CascadeType.ALL)
    private Teacher teacher;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<University> universities = new HashSet<>();


    public Country() {
    }

    public Country(long id, String name_country, Set<City> cities,
                   Teacher teacher, Set<Student> students, Set<University> universities) {
        this.id = id;
        this.name_country = name_country;
        this.cities = cities;
        this.teacher = teacher;
        this.students = students;
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

    public Set<City> getCities() {
        return cities;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Set<University> getUniversities() {
        return universities;
    }

    public void setUniversities(Set<University> universities) {
        this.universities = universities;
        for (University university: universities){
            university.setCountry(this);
        }
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
        for (Student student: students){
            student.setCountry(this);
        }
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
        for ( City city: cities){
            city.setCountry(this);
        }
    }
}
