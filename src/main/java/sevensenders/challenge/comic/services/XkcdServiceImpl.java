package sevensenders.challenge.comic.services;

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

    public XkcdServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Xkcd getLastComic() {
        Xkcd lastComic = restTemplate.getForObject("https://xkcd.com/info.0.json", Xkcd.class);
        lastComic.setLink("https://xkcd.com/"+ lastComic.getNum() +"/info.0.json");
        return  lastComic;
    }

    @Override
    public Xkcd getComicByNum(Integer num) {
        Xkcd comicByNum =restTemplate.getForObject("https://xkcd.com/" +num+"/info.0.json", Xkcd.class);
        comicByNum.setLink("https://xkcd.com/"+ num +"/info.0.json");
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
