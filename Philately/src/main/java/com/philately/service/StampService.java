package com.philately.service;

import com.philately.model.dto.AddStampDto;
import com.philately.model.dto.StampDetailsDto;

import java.util.List;
import java.util.Set;

public interface StampService {

    void addStamp(AddStampDto addStampDto);

    List<StampDetailsDto> getAllUserStamps(String userUUID);
}
