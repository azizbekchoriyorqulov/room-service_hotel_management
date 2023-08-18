package uz.pdp.roomservice.domain.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoomEntity extends BaseEntity {

    private UUID hotelId;
    private String size;
    private Boolean isActive=false;
    private double price;
    private String description;
    private String smallDescription;


    @Enumerated(EnumType.STRING)
    private RoomType types ;
}
