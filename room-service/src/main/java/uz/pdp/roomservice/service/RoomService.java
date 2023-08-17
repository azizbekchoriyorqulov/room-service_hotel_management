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
   public List<RoomEntity> getByTypeOfHotel(String type, UUID hotelId){

      return roomRepository.findByTypesAndHotel_id(type, hotelId);
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

   public String deleteByIdAndHotelId(UUID roomId, UUID hotelId){
      RoomEntity room = roomRepository.findRoomEntitiesByHotel_idAndId(hotelId,roomId)
              .orElseThrow(()->new DataNotFoundException("Room or Hotel not found"));
      roomRepository.deleteByIdAndHotel_id(roomId, hotelId);
      return "OK";
   }
   public void isActive(UUID roomId, UUID hotelId, Boolean isActive){
      RoomEntity room=roomRepository.findRoomEntitiesByHotel_idAndId(hotelId,roomId).orElseThrow(()->  new DataNotFoundException("Room not found"));
      room.setIsActive(isActive);
      roomRepository.save(room);
   }

   public List<RoomEntity> getByActives(UUID hotelId, Boolean isActive){
      return roomRepository.findRoomEntitiesByHotel_idAndIsActive(hotelId, isActive);
   }

}
