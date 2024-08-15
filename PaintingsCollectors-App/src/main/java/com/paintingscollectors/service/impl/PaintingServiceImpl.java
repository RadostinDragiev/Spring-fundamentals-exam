package com.paintingscollectors.service.impl;

import com.paintingscollectors.model.dto.AddPaintingDto;
import com.paintingscollectors.model.dto.PaintingDto;
import com.paintingscollectors.model.entity.Painting;
import com.paintingscollectors.model.entity.Style;
import com.paintingscollectors.model.entity.User;
import com.paintingscollectors.repository.PaintingRepository;
import com.paintingscollectors.service.PaintingService;
import com.paintingscollectors.service.StyleService;
import com.paintingscollectors.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaintingServiceImpl implements PaintingService {

    private final PaintingRepository paintingRepository;
    private final UserService userService;
    private final StyleService styleService;
    private final ModelMapper modelMapper;

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

    @Override
    public void addToFavorite(String username, String paintingUUID) {
        Painting painting = this.paintingRepository.findById(paintingUUID).orElse(null);
        if (painting != null && !painting.getAuthor().getUsername().equals(username)) {
            painting.setFavorite(true);
            this.userService.addFavoritePainting(username, painting);
        }
    }

    @Override
    public void addVote(String username, String paintingUUID) {
        Painting painting = this.paintingRepository.findById(paintingUUID).orElse(null);
        if (painting != null && !painting.getAuthor().getUsername().equals(username)) {
            long votes = painting.getVotes() + 1;
            painting.setVotes(votes);
            this.userService.addVotePainting(username, painting);
            this.paintingRepository.saveAndFlush(painting);
        }
    }

    @Override
    public List<PaintingDto> getAllByUsername(String username) {
        return Arrays.stream(this.modelMapper
                        .map(this.paintingRepository.findAllByAuthorUsername(username), PaintingDto[].class))
                .toList();
    }

    @Override
    public List<PaintingDto> getOthersPaintings(String username) {
        return Arrays.stream(this.modelMapper
                        .map(this.paintingRepository.findAllByAuthorUsernameIsNot(username), PaintingDto[].class))
                .toList();
    }

    @Override
    public List<PaintingDto> getOwnFavoritePaintings(String username) {
        return Arrays.stream(this.modelMapper
                        .map(this.paintingRepository.findAllByFavoriteUsersUsername(username), PaintingDto[].class))
                .toList();
    }

    @Override
    public List<PaintingDto> getMostRatedPaintings() {
        return Arrays.stream(this.modelMapper
                        .map(this.paintingRepository.findAllOrderByVotes(), PaintingDto[].class))
                .toList();
    }

    @Override
    public void removePainting(String uuid) {
        this.paintingRepository.deleteByUUID(uuid);
    }

    @Override
    public void removeVote(String username, String paintingUUID) {
    }
}
