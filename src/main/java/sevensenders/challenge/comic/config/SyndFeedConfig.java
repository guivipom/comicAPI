package sevensenders.challenge.comic.config;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SyndFeedConfig {

    @Bean
    public SyndFeed syndFeed(){

        return new SyndFeedImpl();
    }
}
