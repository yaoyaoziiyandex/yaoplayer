package yaoyaozii;

import java.util.logging.Logger;
import java.util.logging.Level;

public class YLog 
{
  final static Logger LOGGER = Logger.getLogger(YLog.class.getName());

  void run() 
  {
    //LOGGER.setLevel(Level.SEVERE);
    LOGGER.severe("Info Log");
    LOGGER.warning("Info Log");
    LOGGER.info("Info Log");
    LOGGER.finest("Really not important");
  }
}
