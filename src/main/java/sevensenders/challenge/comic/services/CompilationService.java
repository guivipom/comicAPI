package sevensenders.challenge.comic.services;

import sevensenders.challenge.api.domain.ComicCompilation;

import java.util.List;

public interface CompilationService {
    List<ComicCompilation> getComics(Integer limit);

}
