package yaoyaozii;

import java.util.logging.Logger;
import java.util.logging.Level;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;

public class GHttp 
{
  private final static Logger LOGGER = Logger.getLogger(GHttp.class.getName());

  //static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
  //static final JsonFactory JSON_FACTORY = new JacksonFactory();

  public static void run() 
  {
    LOGGER.setLevel(Level.FINEST);
    LOGGER.severe("Info Log");
    LOGGER.warning("Info Log");
    LOGGER.info("Info Log");
    LOGGER.finest("Really not important");
  }
}
