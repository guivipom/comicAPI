package sevensenders.challenge.comic.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sevensenders.challenge.api.domain.ComicCompilation;
import sevensenders.challenge.api.domain.Xkcd;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XkcdServiceImplTest {

    @Autowired
    XkcdService xkcdService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getLastComic() {
        Xkcd comic = xkcdService.getLastComic();
        assertEquals("https://xkcd.com/"+ comic.getNum() , comic.getLink());
    }

    @Test
    public void getComicByNum() {
        Xkcd comic = xkcdService.getComicByNum(22);
        assertEquals(Integer.valueOf(22), comic.getNum());
    }

    @Test
    public void getComics() {
        List<Xkcd> comics = xkcdService.getComics(2);
        assertEquals(2, comics.size());
    }

    @Test
    public void getEmptyComicsList() {
        List<Xkcd> comics = xkcdService.getComics(0);
        assertEquals(1, comics.size());
    }

    public void getCompilation(){
        List<Xkcd> comicsXkcd = xkcdService.getComics(2);
        List<ComicCompilation> comicCompilation = xkcdService.getCompilation(2);

        assertEquals( comicsXkcd.size(), comicCompilation.size());
        assertEquals( comicsXkcd.get(0).getLink(), comicCompilation.get(0).getUrl());
    }
}