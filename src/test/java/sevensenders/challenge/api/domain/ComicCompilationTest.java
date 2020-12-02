package sevensenders.challenge.api.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComicCompilationTest {

    ComicCompilation comicCompilation;

    @Before
    public void setUp() throws Exception {
        comicCompilation = new ComicCompilation();
    }

    @Test
    public void getTitle() {
        comicCompilation.setTitle("Title test");
        assertEquals("Title test", comicCompilation.getTitle());
    }
}