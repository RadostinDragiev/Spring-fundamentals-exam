package com.paintingscollectors.service.impl;

import com.paintingscollectors.model.entity.Style;
import com.paintingscollectors.model.entity.StyleName;
import com.paintingscollectors.repository.StyleRepository;
import com.paintingscollectors.service.StyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StyleServiceImpl implements StyleService {

    private final StyleRepository styleRepository;

    @Override
    public Style getStyleByName(String styleName) {
        return this.styleRepository.findStyleByName(StyleName.valueOf(styleName));
    }
}
