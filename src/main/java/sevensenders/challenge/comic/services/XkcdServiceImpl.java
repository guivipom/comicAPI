package sevensenders.challenge.comic.services;

import org.springframework.stereotype.Service;
import sevensenders.challenge.api.domain.Xkcd;

import java.util.List;

@Service
public class XkcdServiceImpl implements XkcdService {
    @Override
    public Xkcd getLastComic(Integer num) {
        return null;
    }

    @Override
    public Xkcd getComicByNum(Integer num) {
        return null;
    }

    @Override
    public List<Xkcd> getComics(Integer limit) {
        return null;
    }
}
