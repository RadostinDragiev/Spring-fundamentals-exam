package com.paintingscollectors.service.impl;

import com.paintingscollectors.model.dto.AddPaintingDto;
import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.model.entity.Style;
import com.paintingscollectors.model.entity.User;
import com.paintingscollectors.repository.PaintingRepository;
import com.paintingscollectors.service.PaintingService;
import com.paintingscollectors.service.StyleService;
import com.paintingscollectors.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaintingServiceImpl implements PaintingService {

    private final PaintingRepository paintingRepository;
    private final UserService userService;
    private final StyleService styleService;

    @Override
    public void addPainting(AddPaintingDto addPaintingDto) {

        User user = this.userService.getUserByName(addPaintingDto.getAuthor());
        Style style = this.styleService.getStyleByName(addPaintingDto.getStyle());

        Painting painting = Painting.builder()
                .name(addPaintingDto.getName())
                .author(user)
                .owner(user)
                .imageUrl(addPaintingDto.getImageUrl())
                .style(style)
                .isFavorite(false)
                .votes(0).build();

        this.paintingRepository.saveAndFlush(painting);
    }
}
