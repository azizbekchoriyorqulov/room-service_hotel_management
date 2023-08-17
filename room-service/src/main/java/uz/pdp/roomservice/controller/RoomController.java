package uz.pdp.roomservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.roomservice.domain.dto.RoomRequestDto;
import uz.pdp.roomservice.domain.entity.RoomEntity;
import uz.pdp.roomservice.service.RoomService;

import java.util.List;
import java.util.UUID;

@RequestMapping("room/api/v1")
@RequiredArgsConstructor
@RestController
public class RoomController {
    private final RoomService roomService;

    @GetMapping("{hotel_id}/getByType")
    public ResponseEntity<List<RoomEntity>> getByType(@RequestParam String type, @PathVariable UUID hotel_id) {
        return ResponseEntity.ok(roomService.getByTypeOfHotel(type, hotel_id));
    }

    @PostMapping("/add")
    public ResponseEntity<RoomEntity> addRoom(@RequestBody RoomRequestDto roomRequestDto) {
        return ResponseEntity.ok(roomService.save(roomRequestDto));
    }

    @PutMapping("{id}/update")
    public ResponseEntity<RoomEntity> updateRoom(
            @RequestBody RoomRequestDto roomRequestDto,
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok(roomService.update(roomRequestDto, id));
    }


    @GetMapping("{id}/byActives")
    public ResponseEntity<List<RoomEntity>> hotelActives(@PathVariable UUID hotelId, @RequestParam Boolean isActive) {
        return ResponseEntity.ok(roomService.getByActives(hotelId,isActive));
    }

    @DeleteMapping("{hotelId}/{roomId}/delete")
    public ResponseEntity<String> deleteByRoomIdAndHotelId(
            @PathVariable UUID hotelId,
            @PathVariable UUID roomId
    ){
        return ResponseEntity.ok(roomService.deleteByIdAndHotelId(roomId, hotelId));
    }

    @PutMapping("{hotelId}/{roomId}/change")
    public ResponseEntity<String> changeRoom(@PathVariable UUID hotelId,
                                             @PathVariable UUID roomId,
                                             @RequestParam Boolean isActive){
        roomService.isActive(roomId,hotelId,isActive);
         return ResponseEntity.ok("OK");

    }
}
