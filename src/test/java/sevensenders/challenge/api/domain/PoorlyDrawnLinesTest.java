package sevensenders.challenge.api.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PoorlyDrawnLinesTest {

    private PoorlyDrawnLines poorlyDrawnLines;

    @Before
    public void setUp() throws Exception {
        poorlyDrawnLines = new PoorlyDrawnLines();
    }

    @Test
    public void getTitle() {
        poorlyDrawnLines.setTitle("Title test");
        assertEquals("Title test", poorlyDrawnLines.getTitle());
    }
}