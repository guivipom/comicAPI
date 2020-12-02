package sevensenders.challenge.api.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class XkcdTest {

    Xkcd xkcd;

    @Before
    public void setUp(){
        xkcd = new Xkcd();
    }

    @Test
    public void getTitle() throws Exception {
        xkcd.setTitle("Title test");
        assertEquals("Title test", xkcd.getTitle());
    }
    // ...
}