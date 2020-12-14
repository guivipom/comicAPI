package sevensenders.challenge.comic.services;

import com.sun.syndication.feed.rss.Item;
import org.springframework.stereotype.Service;
import sevensenders.challenge.api.domain.ComicCompilation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CompilationServiceImpl implements CompilationService {

    private XkcdService xkcdService;
    private PoorlyDrawnLinesService poorlyDrawnLinesService;

    public CompilationServiceImpl(XkcdService xkcdService, PoorlyDrawnLinesService poorlyDrawnLinesService) {
        this.xkcdService = xkcdService;
        this.poorlyDrawnLinesService = poorlyDrawnLinesService;
    }

    @Override
    public List<ComicCompilation> getComics(Integer limit) {
        List<ComicCompilation> comicCompilation = new ArrayList<>();
        comicCompilation = Stream.concat(xkcdService.getCompilation(limit).stream(),
                                        poorlyDrawnLinesService.getCompilation(limit).stream())
                                    .collect(Collectors.toList());

        return  comicCompilation.stream()
                                .sorted(Comparator.comparing(ComicCompilation::getPublished,Comparator.nullsLast(Comparator.reverseOrder())))
                                .collect(Collectors.toList());

    }
}
