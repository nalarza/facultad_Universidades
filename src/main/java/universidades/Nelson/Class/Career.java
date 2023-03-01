package universidades.Nelson.Class;

import jakarta.persistence.*;

@Entity
@Table(name = "career")
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( unique = true, nullable = false)
    private long id_career;
    private String name_career;
    private String structure_career;

    public Career() {
    }

    public Career(long id_career, String name_career, String structure_career) {
        this.id_career = id_career;
        this.name_career = name_career;
        this.structure_career = structure_career;
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
}
