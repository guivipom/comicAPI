package sevensenders.challenge.comic.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sevensenders.challenge.api.domain.ComicCompilation;
import sevensenders.challenge.api.domain.Xkcd;
import sevensenders.challenge.comic.services.ApiService;
import sevensenders.challenge.comic.services.CompilationService;
import sevensenders.challenge.comic.services.XkcdService;

import java.util.List;

@RestController
public class ComicController {
    private ApiService apiService;

    public ComicController(ApiService apiService) {
        this.apiService = apiService;

    }

    @RequestMapping("/compilation")
    public List<ComicCompilation> getCompilation() {
        return apiService.getCompilation(10);
    }

    @RequestMapping("/xkcd/lastcomic")
    public Xkcd getLastComic(){
        return apiService.getXkcdLastComic();
    }

    @RequestMapping("/xkcd/comics")
    public List<Xkcd> getComics(){
        return apiService.getXkcdComics(10);
    }
}
