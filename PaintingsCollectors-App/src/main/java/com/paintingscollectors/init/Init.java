package com.paintingscollectors.init;

import com.paintingscollectors.model.entity.Style;
import com.paintingscollectors.model.entity.StyleName;
import com.paintingscollectors.repository.StyleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Init implements CommandLineRunner {
    private final StyleRepository styleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (styleRepository.count() == 0) {
            List<Style> styles = new ArrayList<>();
            styles.add(Style.builder()
                    .name(StyleName.IMPRESSIONISM)
                    .description("Impressionism is a painting style most commonly associated with the 19th century where small brush strokes are used to build up a larger picture.").build());

            styles.add(Style.builder()
                    .name(StyleName.ABSTRACT)
                    .description("Abstract art does not attempt to represent recognizable subjects in a realistic manner.").build());

            styles.add(Style.builder()
                    .name(StyleName.EXPRESSIONISM)
                    .description("Expressionism is a style of art that doesn't concern itself with realism.").build());

            styles.add(Style.builder()
                    .name(StyleName.SURREALISM)
                    .description("Surrealism is characterized by dreamlike, fantastical imagery that often defies logical explanation.").build());

            styles.add(Style.builder()
                    .name(StyleName.REALISM)
                    .description("Also known as naturalism, this style of art is considered as 'real art' and has been the dominant style of painting since the Renaissance.").build());

            styleRepository.saveAllAndFlush(styles);
        }
    }
}
