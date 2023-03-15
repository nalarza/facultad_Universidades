package universidades.Nelson.Class;

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
}
