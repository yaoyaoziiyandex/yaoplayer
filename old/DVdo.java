package yaoyaozii;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.List;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Key;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.json.JsonObjectParser;

// http://www.dailymotion.com/doc/api/graph-api.html

public class DVdo 
{
  private final static Logger LOGGER = Logger.getLogger(DVdo.class.getName());

  static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
  static final JsonFactory JSON_FACTORY = new JacksonFactory();
  
  /** Represents a video feed. */
  public static class VideoFeed {
    @Key public List<Video> list;
    @Key("has_more") public boolean hasMore;
  }

  /** Represents a video. */
  public static class Video {
    @Key public String id;
    @Key public List<String> tags;
    @Key public String title;
    @Key public String url;
  }

  /** URL for Dailymotion API. */
  public static class DailyMotionUrl extends GenericUrl {
    public DailyMotionUrl(String encodedUrl) {
      super(encodedUrl);
    }
  
    @Key public String fields;
  }

  public void run() throws Exception 
  { 
    HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(
                                          new HttpRequestInitializer() {
                                            @Override
                                            public void initialize(HttpRequest request) {
                                              request.setParser(new JsonObjectParser(JSON_FACTORY));
                                            }
                                        });
    DailyMotionUrl url = new DailyMotionUrl("https://api.dailymotion.com/videos/");
    url.fields = "id,tags,title,url";
    HttpRequest request = requestFactory.buildGetRequest(url);
    VideoFeed videoFeed = request.execute().parseAs(VideoFeed.class);
    if (videoFeed.list.isEmpty()) {
      LOGGER.info("No videos found.");
    } else {
      if (videoFeed.hasMore) {
        LOGGER.info("First ");
      }
      LOGGER.info(videoFeed.list.size() + " videos found:");
      for (Video video : videoFeed.list) {
        LOGGER.info(" ");
        LOGGER.info("-----------------------------------------------");
        LOGGER.info("ID: " + video.id);
        LOGGER.info("Title: " + video.title);
        LOGGER.info("Tags: " + video.tags);
        LOGGER.info("URL: " + video.url);
      }
    }
  }
}
