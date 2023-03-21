package universidades.Nelson.Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id_student;
    private String names_student;
    private String surnames_student;
    private String email_student;
    private String date_student;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_country")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_city")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  City city;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_university")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private University university;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_faculty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Faculty faculty;

    @OneToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_career")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Career career;

    public Long getId_student() {
        return id_student;
    }

    public void setId_student(Long id_student) {
        this.id_student = id_student;
    }

    public String getNames_student() {
        return names_student;
    }

    public void setNames_student(String names_student) {
        this.names_student = names_student;
    }

    public String getSurnames_student() {
        return surnames_student;
    }

    public void setSurnames_student(String surnames_student) {
        this.surnames_student = surnames_student;
    }

    public String getEmail_student() {
        return email_student;
    }

    public void setEmail_student(String email_student) {
        this.email_student = email_student;
    }

    public String getDate_student() {
        return date_student;
    }

    public void setDate_student(String date_student) {
        this.date_student = date_student;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }
}
