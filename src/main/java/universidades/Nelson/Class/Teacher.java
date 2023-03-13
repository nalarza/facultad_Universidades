package universidades.Nelson.Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_teacher;
    private String names_teacher;
    private String sur_name_teacher;
    private String phone_number_teacher;
    private String email_teacher;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_country")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Country country;


    public Teacher() {
    }


    public long getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(long id_teacher) {
        this.id_teacher = id_teacher;
    }

    public String getNames_teacher() {
        return names_teacher;
    }

    public void setNames_teacher(String names_teacher) {
        this.names_teacher = names_teacher;
    }

    public String getSur_name_teacher() {
        return sur_name_teacher;
    }

    public void setSur_name_teacher(String sur_name_teacher) {
        this.sur_name_teacher = sur_name_teacher;
    }

    public String getPhone_number_teacher() {
        return phone_number_teacher;
    }

    public void setPhone_number_teacher(String phone_number_teacher) {
        this.phone_number_teacher = phone_number_teacher;
    }



    public String getEmail_teacher() {
        return email_teacher;
    }

    public void setEmail_teacher(String email_teacher) {
        this.email_teacher = email_teacher;
    }
}
