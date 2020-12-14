package sevensenders.challenge.comic.services;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sevensenders.challenge.api.domain.ComicCompilation;
import sevensenders.challenge.api.domain.PoorlyDrawnLines;
import sevensenders.challenge.api.domain.Xkcd;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoorlyDrawnLinesServiceImplTest {
    @Autowired
    PoorlyDrawnLinesService poorlyDrawnLinesService;

    @Value("${poorlydrawnlines.feed}")
    String feed;

    @Test
    public void getComics() throws IOException, FeedException {
        List<PoorlyDrawnLines> comics = poorlyDrawnLinesService.getComics(10);
        System.out.println(comics.size());
    }

    @Test
    public void getCompilation() throws IOException, FeedException {
        List<PoorlyDrawnLines> comicsPDL = poorlyDrawnLinesService.getComics(2);
        List<ComicCompilation> comicCompilation = poorlyDrawnLinesService.getCompilation(2);

        assertEquals( comicsPDL.size(), comicCompilation.size());
        assertEquals( comicsPDL.get(0).getUrl(), comicCompilation.get(0).getUrl());
    }
}