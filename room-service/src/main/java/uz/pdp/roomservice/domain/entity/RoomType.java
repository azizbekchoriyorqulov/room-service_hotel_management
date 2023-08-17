package uz.pdp.roomservice.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "room_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomType extends BaseEntity {
    private String type;

}
