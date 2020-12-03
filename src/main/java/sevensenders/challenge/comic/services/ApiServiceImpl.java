package sevensenders.challenge.comic.services;

import org.springframework.stereotype.Service;
import sevensenders.challenge.api.domain.ComicCompilation;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private CompilationService compilationService;

    public ApiServiceImpl(CompilationService compilationService) {
        this.compilationService = compilationService;
    }

    @Override
    public List<ComicCompilation> getCompilation(Integer limit) {
        return null;
    }
}
