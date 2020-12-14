package sevensenders.challenge.comic.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sevensenders.challenge.api.domain.ComicCompilation;
import sevensenders.challenge.api.domain.Xkcd;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompilationServiceImplTest {

    @Autowired
    private CompilationService compilationService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getComics() {
        List<ComicCompilation> comics = compilationService.getComics(10);

        LocalDate previousTime = comics.iterator().next().getPublished();

        assertEquals(20, comics.size());

        for (ComicCompilation comic : comics) {
            assertTrue( previousTime.compareTo(comic.getPublished()) >=0 );
            previousTime = comic.getPublished();
            }


    }
}
