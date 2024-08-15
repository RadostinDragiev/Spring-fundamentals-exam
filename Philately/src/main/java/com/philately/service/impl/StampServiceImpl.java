package com.philately.service.impl;

import com.philately.config.UserSession;
import com.philately.model.dto.AddStampDto;
import com.philately.model.entity.Paper;
import com.philately.model.entity.Stamp;
import com.philately.model.entity.User;
import com.philately.repository.StampRepository;
import com.philately.service.PaperService;
import com.philately.service.StampService;
import com.philately.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StampServiceImpl implements StampService {

    private final StampRepository stampRepository;
    private final UserSession userSession;
    private final UserService userService;
    private final PaperService paperService;
    private final ModelMapper modelMapper;

    @Override
    public void addStamp(AddStampDto addStampDto) {
        User user = this.userService.getUserById(this.userSession.getId());
        Paper paper = this.paperService.getPaperByName(addStampDto.getPaperName());
        Stamp stamp = this.modelMapper.map(addStampDto, Stamp.class);
        stamp.setOwner(user);
        stamp.setPaper(paper);

        this.stampRepository.saveAndFlush(stamp);
    }
}
