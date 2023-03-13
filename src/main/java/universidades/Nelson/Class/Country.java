package universidades.Nelson.Class;

import com.fasterxml.jackson.annotation.JsonProperty;
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





    public Country() {
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



    public void setCities(Set<City> cities) {
        this.cities = cities;
        for ( City city: cities){
            city.setCountry(this);
        }
    }
}
