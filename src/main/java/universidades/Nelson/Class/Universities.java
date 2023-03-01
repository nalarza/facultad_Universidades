package universidades.Nelson.Class;

import jakarta.persistence.*;

@Entity
@Table(name = "university")
public class Universities {
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





    public Universities() {
    }

    public Universities(long id_university, String name_university, String email_university, String address_university, String phone_number_university, String city_university, String country_university) {
        this.id= id;
        this.name_university = name_university;
        this.email_university = email_university;
        this.address_university = address_university;
        this.phone_number_university = phone_number_university;
        this.city_university = city_university;
        this.country_university = country_university;
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
