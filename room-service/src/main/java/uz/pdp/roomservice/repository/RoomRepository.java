package uz.pdp.roomservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.roomservice.domain.entity.RoomEntity;
import uz.pdp.roomservice.domain.entity.RoomType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity , UUID> {
    Optional<RoomEntity> findBySize(String size);
    Optional<RoomEntity> findById(UUID uuid);
    Optional<RoomEntity> findRoomEntitiesByHotelIdAndId(UUID hotelId, UUID roomId);
    List<RoomEntity> findRoomEntitiesByHotelIdAndIsActive(UUID hotelId, boolean activeStatus);
    void deleteByIdAndHotelId(UUID roomId, UUID hotelId);
    List<RoomEntity> findByTypesAndHotelId (String type, UUID id);
}
