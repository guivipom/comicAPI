package sevensenders.challenge.comic.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sevensenders.challenge.api.domain.ComicCompilation;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServiceImplTest {

    @Autowired
    private CompilationService compilationService;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getCompilation() {
        List<ComicCompilation> comics = compilationService.getComics(2);
        assertEquals(2, comics.size());
    }
}