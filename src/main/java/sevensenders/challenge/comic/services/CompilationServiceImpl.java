package sevensenders.challenge.comic.services;

import org.springframework.stereotype.Service;
import sevensenders.challenge.api.domain.ComicCompilation;

import java.util.List;

@Service
public class CompilationServiceImpl implements CompilationService {

    private XkcdService xkcdService;

    public CompilationServiceImpl(XkcdService xkcdService) {
        this.xkcdService = xkcdService;
    }

    @Override
    public List<ComicCompilation> getComics(Integer limit) {
        return xkcdService.getCompilation(limit);
    }
}
