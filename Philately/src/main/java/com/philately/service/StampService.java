package com.philately.service;

import com.philately.model.dto.AddStampDto;
import com.philately.model.dto.StampDetailsDto;
import com.philately.model.entity.Stamp;

import java.util.List;

public interface StampService {

    void addStamp(AddStampDto addStampDto);

    Stamp getStampById(String stampUUID);

    List<StampDetailsDto> getAllUserStamps(String userUUID);

    List<StampDetailsDto> getAllStampsByOthers(String userUUID);

    List<StampDetailsDto> getUsersWishlist();

    List<StampDetailsDto> getAllPurchased();
}
