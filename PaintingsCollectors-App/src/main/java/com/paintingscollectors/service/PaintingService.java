package com.paintingscollectors.service;

import com.paintingscollectors.model.dto.AddPaintingDto;
import com.paintingscollectors.model.dto.PaintingDto;

import java.util.List;

public interface PaintingService {

    void addPainting(AddPaintingDto addPaintingDto);

    void addToFavorite(String username, String paintingUUID);

    void addVote(String username, String paintingUUID);

    List<PaintingDto> getAllByUsername(String username);

    List<PaintingDto> getOthersPaintings(String username);

    List<PaintingDto> getOwnFavoritePaintings(String username);

    List<PaintingDto> getMostRatedPaintings();

    void removePainting(String uuid);

    void removeVote(String username, String paintingUUID);
}
