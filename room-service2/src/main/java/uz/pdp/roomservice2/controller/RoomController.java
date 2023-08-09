package uz.pdp.roomservice2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.roomservice2.domain.dto.RoomRequestDto;
import uz.pdp.roomservice2.domain.entity.RoomType;
import uz.pdp.roomservice2.service.RoomService;

import java.util.UUID;

@RequestMapping("room/api/v1")
@RequiredArgsConstructor
@RestController
public class RoomController {
    private final RoomService roomService;

    @GetMapping("/getALL")
    public ResponseEntity getAll(@RequestParam RoomType type) {
        roomService.getAll(type);
        return ResponseEntity.ok(roomService.getAll(type));
    }

    @PostMapping("/add")
    public ResponseEntity addRoom(@RequestBody RoomRequestDto roomRequestDto) {
        return ResponseEntity.ok(roomService.save(roomRequestDto));
    }

    @PutMapping("{id}/update")
    public ResponseEntity updateRoom(
            @RequestBody RoomRequestDto roomRequestDto,
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok(roomService.update(roomRequestDto, id));
    }

    @GetMapping("{size}/deleteBySize")
    public ResponseEntity delete(@PathVariable String size) {
     roomService.deleteBySize(size);
     return ResponseEntity.ok().body("room delete ");
    }

    @GetMapping("{id}/isActive")
    public ResponseEntity isActive(@PathVariable UUID id) {
        roomService.isActive(id);
        return ResponseEntity.ok().body("successful");
    }
}
