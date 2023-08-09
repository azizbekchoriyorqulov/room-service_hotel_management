package uz.pdp.roomservice2.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.roomservice2.domain.entity.RoomType;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomRequestDto {
    private String size;
    private Boolean isActive=false;
    private double price;
    private List<RoomType> types ;
}
