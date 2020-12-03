package sevensenders.challenge.comic.services;

import sevensenders.challenge.api.domain.ComicCompilation;
import sevensenders.challenge.api.domain.Xkcd;

import java.util.List;

public interface ApiService {

    List<ComicCompilation> getCompilation(Integer limit);
    List<Xkcd> getXkcdComics(Integer limit);
    Xkcd getXkcdLastComic();
}
