package com.example.roomservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.roomservice.domain.entity.RoomEntity;
import com.example.roomservice.domain.entity.RoomType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity , UUID> {
    Optional<RoomEntity> findBySize(String size);
    Optional<RoomEntity> findById(UUID uuid);

    List<RoomEntity> findByTypes (RoomType type);
}
