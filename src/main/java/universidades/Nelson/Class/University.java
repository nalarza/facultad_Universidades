package universidades.Nelson.Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "university")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_university",unique = true, nullable = false)
    private long id;
    private String name_university;
    private String email_university;
    private String address_university;
    private String phone_number_university;
    private String city_university;
    private String country_university;

    @OneToOne(fetch =FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_city")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private City city;

    @OneToMany(mappedBy = "university",cascade = CascadeType.ALL)
    private Set<Faculty> faculties = new HashSet<>();



    public University() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_university() {
        return name_university;
    }

    public void setName_university(String name_university) {
        this.name_university = name_university;
    }

    public String getEmail_university() {
        return email_university;
    }

    public void setEmail_university(String email_university) {
        this.email_university = email_university;
    }

    public String getAddress_university() {
        return address_university;
    }

    public void setAddress_university(String address_university) {
        this.address_university = address_university;
    }

    public String getPhone_number_university() {
        return phone_number_university;
    }

    public void setPhone_number_university(String phone_number_university) {
        this.phone_number_university = phone_number_university;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
        for (Faculty faculty: faculties ){
            faculty.setUniversity(this);
        }
    }

    public String getCity_university() {
        return city_university;
    }

    public void setCity_university(String city_university) {
        this.city_university = city_university;
    }

    public String getCountry_university() {
        return country_university;
    }

    public void setCountry_university(String country_university) {
        this.country_university = country_university;
    }

}
