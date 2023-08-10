package uz.pdp.roomservice.domain.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoomEntity extends BaseEntity {

    private String size;
    private Boolean isActive=false;
    private double price;
    @ManyToOne
    private List<RoomType> types ;
}
