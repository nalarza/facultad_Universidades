package universidades.Nelson.Class;

import jakarta.persistence.*;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id_room;
    private String name_room;
    private String code_block_room;
    private String floor_room;
}
