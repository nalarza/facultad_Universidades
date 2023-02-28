package universidades.Nelson.Class;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_country;
    private String name_country;
}
