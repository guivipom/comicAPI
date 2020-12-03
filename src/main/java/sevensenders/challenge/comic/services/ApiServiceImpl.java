package sevensenders.challenge.comic.services;

import org.springframework.stereotype.Service;
import sevensenders.challenge.api.domain.ComicCompilation;
import sevensenders.challenge.api.domain.Xkcd;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private CompilationService compilationService;
    private XkcdService xkcdService;

    public ApiServiceImpl(CompilationService compilationService, XkcdService xkcdService) {
        this.compilationService = compilationService;
        this.xkcdService = xkcdService;
    }

    @Override
    public List<ComicCompilation> getCompilation(Integer limit) {
        return compilationService.getComics(limit);
    }

    @Override
    public List<Xkcd> getXkcdComics(Integer limit) {
        return xkcdService.getComics(limit);
    }

    @Override
    public Xkcd getXkcdLastComic() {
        return xkcdService.getLastComic();
    }
}
