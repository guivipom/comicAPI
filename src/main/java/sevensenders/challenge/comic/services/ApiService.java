package sevensenders.challenge.comic.services;

import sevensenders.challenge.api.domain.ComicCompilation;

import java.util.List;

public interface ApiService {

    List<ComicCompilation> getCompilation(Integer limit);
}
