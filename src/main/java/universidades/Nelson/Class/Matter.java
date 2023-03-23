package universidades.Nelson.Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "matter")
public class Matter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private long id_matter;
    private String type_matter;
    private String name_matter;
    private String credit_matter;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_career")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Career career;

    public Matter() {
    }

    public Matter(long id_matter, String type_matter, String name_matter,
                  String credit_matter, Career career) {
        this.id_matter = id_matter;
        this.type_matter = type_matter;
        this.name_matter = name_matter;
        this.credit_matter = credit_matter;
        this.career = career;
    }

    public long getId_matter() {
        return id_matter;
    }

    public void setId_matter(long id_matter) {
        this.id_matter = id_matter;
    }

    public String getType_matter() {
        return type_matter;
    }

    public void setType_matter(String type_matter) {
        this.type_matter = type_matter;
    }

    public String getName_matter() {
        return name_matter;
    }

    public void setName_matter(String name_matter) {
        this.name_matter = name_matter;
    }

    public String getCredit_matter() {
        return credit_matter;
    }

    public void setCredit_matter(String credit_matter) {
        this.credit_matter = credit_matter;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }
}
