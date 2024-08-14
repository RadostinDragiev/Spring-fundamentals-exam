package com.paintingscollectors.service;

import com.paintingscollectors.model.dto.AddPaintingDto;
import com.paintingscollectors.model.dto.PaintingDto;

import java.util.List;

public interface PaintingService {

    void addPainting(AddPaintingDto addPaintingDto);

    List<PaintingDto> getAllByUsername(String username);

    void removePainting(String uuid);
}
