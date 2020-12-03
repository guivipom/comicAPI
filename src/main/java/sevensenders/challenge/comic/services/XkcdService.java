package sevensenders.challenge.comic.services;

import sevensenders.challenge.api.domain.Xkcd;

import java.util.List;

public interface XkcdService {
    Xkcd getLastComic(Integer num);
    Xkcd getComicByNum(Integer num);
    List<Xkcd> getComics(Integer limit);
}
