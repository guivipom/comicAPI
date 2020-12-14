package sevensenders.challenge.comic.services;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import sevensenders.challenge.api.domain.ComicCompilation;
import sevensenders.challenge.api.domain.PoorlyDrawnLines;
import sevensenders.challenge.api.domain.Xkcd;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface PoorlyDrawnLinesService {

    List<PoorlyDrawnLines> getComics(Integer limit) throws IOException, FeedException;
    List<ComicCompilation> getCompilation(Integer limit);

}
