package com.paintingscollectors.repository;

import com.paintingscollectors.model.entity.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, String> {

    List<Painting> findAllByAuthorUsername(String username);

    List<Painting> findAllByAuthorUsernameIsNot(String username);

    @Modifying
    @Transactional
    @Query("DELETE FROM Painting AS p WHERE p.uuid = :uuid AND p.isFavorite = false")
    void deleteByUUID(String uuid);
}
