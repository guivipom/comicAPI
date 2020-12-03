package sevensenders.challenge.comic.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sevensenders.challenge.api.domain.ComicCompilation;
import sevensenders.challenge.api.domain.Xkcd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class XkcdServiceImpl implements XkcdService {

    private RestTemplate restTemplate;
    private final String Domain;
    private final String Request;

    public XkcdServiceImpl(RestTemplate restTemplate, @Value("${xkcd.domain}") String Domain, @Value("${xkcd.request}") String Request) {
        this.restTemplate = restTemplate;
        this.Domain = Domain;
        this.Request = Request;
    }

    @Override
    public Xkcd getLastComic() {
        Xkcd lastComic = restTemplate.getForObject(Domain+Request, Xkcd.class);
        lastComic.setLink(Domain+ lastComic.getNum());
        return  lastComic;
    }

    @Override
    public Xkcd getComicByNum(Integer num) {
        Xkcd comicByNum =restTemplate.getForObject(Domain + num + Request, Xkcd.class);
        comicByNum.setLink(Domain + num);
        return comicByNum;
    }

    @Override
    public List<Xkcd> getComics(Integer limit) {
        int currentNum;
        List<Xkcd> comics = new ArrayList<>();
        Xkcd currentComic = getLastComic();

        currentNum = currentComic.getNum();
        comics.add(currentComic);
        currentNum--;

        while(comics.size() < limit){
            currentNum--;
            currentComic = getComicByNum(currentNum);
            comics.add(currentComic);
        }

        return comics;
    }

    @Override
    public List<ComicCompilation> getCompilation(Integer limit) {
        List<ComicCompilation> comicCompilation = new ArrayList<>();
        List<Xkcd> comicsXkcd = new ArrayList<>(getComics(limit));

        comicsXkcd.stream().forEach((comicXkcd) -> {
            ComicCompilation comic = new ComicCompilation();
            LocalDate published = LocalDate.of( Integer.valueOf(comicXkcd.getYear()),
                                                Integer.valueOf(comicXkcd.getMonth()),
                                                Integer.valueOf(comicXkcd.getDay()));

            comic.setTitle(comicXkcd.getTitle());
            comic.setUrl(comicXkcd.getLink());
            comic.setImageUrl(comicXkcd.getImg());
            comic.setPublished(published);

            comicCompilation.add(comic);
        });

        return comicCompilation;
    }
}
