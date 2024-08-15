package com.philately.service.impl;

import com.philately.model.entity.Paper;
import com.philately.model.entity.PaperName;
import com.philately.repository.PaperRepository;
import com.philately.service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaperServiceImpl implements PaperService {

    private final PaperRepository paperRepository;

    @Override
    public Paper getPaperByName(PaperName paperName) {
        return this.paperRepository.findByPaperName(paperName);
    }
}
