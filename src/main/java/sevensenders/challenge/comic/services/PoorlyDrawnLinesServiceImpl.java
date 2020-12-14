package sevensenders.challenge.comic.services;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sevensenders.challenge.api.domain.ComicCompilation;
import sevensenders.challenge.api.domain.PoorlyDrawnLines;
import sevensenders.challenge.api.domain.Xkcd;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PoorlyDrawnLinesServiceImpl implements PoorlyDrawnLinesService {

    private final URL url;
    private SyndFeed feed;

    public PoorlyDrawnLinesServiceImpl(@Value("${poorlydrawnlines.feed}") URL url, SyndFeed feed) {
        this.url = url;
        this.feed = feed;
    }


    @Override
    public List<PoorlyDrawnLines> getComics(Integer limit) {

        List<PoorlyDrawnLines> comics = new ArrayList<>();
        SyndFeedInput input = new SyndFeedInput();
        try {
            feed = input.build(new XmlReader(url));
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern p = Pattern.compile("src=\"(.*?)\"");

        for (final Iterator iter = feed.getEntries().iterator();
             iter.hasNext(); )
        {
            PoorlyDrawnLines comic = new PoorlyDrawnLines();

            final SyndEntry entry = (SyndEntry) iter.next();
            comic.setUrl(entry.getUri());
            comic.setTitle(entry.getTitle());
            comic.setPostTime((entry.getPublishedDate().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate()));
            Matcher m = p.matcher(entry.getContents().toString());
            if(m.find()){
                comic.setImg(m.group(1));
            }

            comics.add(comic);
        }
        return comics;
    }

    @Override
    public List<ComicCompilation> getCompilation(Integer limit) {
        List<ComicCompilation> comicCompilation = new ArrayList<>();
        List<PoorlyDrawnLines> comicsPDL = new ArrayList<>(getComics(limit));

        comicsPDL.stream().forEach((comicPDL) -> {
            ComicCompilation comic = new ComicCompilation();
            comic.setTitle(comicPDL.getTitle());
            comic.setUrl(comicPDL.getUrl());
            comic.setImageUrl(comicPDL.getImg());
            comic.setPublished(comicPDL.getPostTime());

            comicCompilation.add(comic);
        });

        return comicCompilation;
    }
}
