package sevensenders.challenge.comic.services;

import sevensenders.challenge.api.domain.ComicCompilation;
import sevensenders.challenge.api.domain.Xkcd;

import java.util.List;

public interface XkcdService {
    Xkcd getLastComic();
    Xkcd getComicByNum(Integer num);
    List<Xkcd> getComics(Integer limit);
    List<ComicCompilation> getCompilation(Integer limit);
}
