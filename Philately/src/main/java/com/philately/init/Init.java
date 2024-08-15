package com.philately.init;

import com.philately.model.entity.Paper;
import com.philately.model.entity.PaperName;
import com.philately.repository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Init implements CommandLineRunner {
    
    private final PaperRepository paperRepository;

    @Override
    public void run(String... args) throws Exception {
        if (paperRepository.count() == 0) {
            List<Paper> papers = new ArrayList<>();
            papers.add(Paper.builder()
                    .paperName(PaperName.WOVE_PAPER)
                    .description("Has an even texture without any particular distinguishing features.").build());

            papers.add(Paper.builder()
                    .paperName(PaperName.LAID_PAPER)
                    .description("When held up to the light, shows parallel lines of greater or less width running across the stamp.").build());

            papers.add(Paper.builder()
                    .paperName(PaperName.GRANITE_PAPER)
                    .description("Has tiny specks of coloured fibre in it, which can usually be seen with the naked eye.").build());

            paperRepository.saveAllAndFlush(papers);
        }
    }
}
