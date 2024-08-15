package com.philately.service;

import com.philately.model.entity.Paper;
import com.philately.model.entity.PaperName;

public interface PaperService {

    Paper getPaperByName(PaperName paperName);
}
