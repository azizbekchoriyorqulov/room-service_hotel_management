package uz.pdp.roomservice.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.pdp.roomservice.domain.dto.RoomRequestDto;
import uz.pdp.roomservice.domain.entity.RoomEntity;
import uz.pdp.roomservice.domain.entity.RoomType;
import uz.pdp.roomservice.exaption.DataNotFoundException;
import uz.pdp.roomservice.repository.RoomRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomService {
   private final ModelMapper modelMapper;
   private final RoomRepository roomRepository;

   public RoomEntity save(RoomRequestDto roomRequestDto){
       RoomEntity room=modelMapper.map(roomRequestDto ,RoomEntity.class);
      return roomRepository.save(room);
   }
   public List<RoomEntity> getAll(RoomType type){
      return roomRepository.findByTypes(type);
   }
   public RoomEntity update(RoomRequestDto update, UUID roomId){
      RoomEntity room = roomRepository.findById(roomId).orElseThrow(()-> new DataNotFoundException("Room not found"));
      RoomEntity newRoom=modelMapper.map(update,RoomEntity.class);
      newRoom.setId(room.getId());
      if(newRoom.getSize().isEmpty())
         newRoom.setSize(room.getSize());
      if(newRoom.getPrice()==0)
         newRoom.setPrice(room.getPrice());
      if(newRoom.getTypes()==null)
         newRoom.setTypes(room.getTypes());
      if (newRoom.getIsActive()==null)
         newRoom.setIsActive(room.getIsActive());
       modelMapper.map(newRoom,room);
       return roomRepository.save(newRoom);
   }
   public void deleteBySize(String size){
      roomRepository.delete(roomRepository.findBySize(size).orElseThrow(()-> new DataNotFoundException("Room not found by size")));
   }
   public void isActive(UUID id){
      RoomEntity room=roomRepository.findById(id).orElseThrow(()->  new DataNotFoundException("Room not found"));
      room.setIsActive(true);
      roomRepository.save(room);
   }
}
