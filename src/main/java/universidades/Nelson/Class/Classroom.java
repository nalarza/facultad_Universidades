package universidades.Nelson.Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_career")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Career career;

    public Classroom() {
    }

    public Classroom(long id_room, String name_room, String code_block_room,
                     String floor_room, Career career) {
        this.id_room = id_room;
        this.name_room = name_room;
        this.code_block_room = code_block_room;
        this.floor_room = floor_room;
        this.career = career;
    }

    public long getId_room() {
        return id_room;
    }

    public void setId_room(long id_room) {
        this.id_room = id_room;
    }

    public String getName_room() {
        return name_room;
    }

    public void setName_room(String name_room) {
        this.name_room = name_room;
    }

    public String getCode_block_room() {
        return code_block_room;
    }

    public void setCode_block_room(String code_block_room) {
        this.code_block_room = code_block_room;
    }

    public String getFloor_room() {
        return floor_room;
    }

    public void setFloor_room(String floor_room) {
        this.floor_room = floor_room;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }
}
