package yaoyaozii;

import java.util.logging.Logger;
import java.util.logging.Level;

public class App 
{
  private final static Logger LOGGER = Logger.getLogger(App.class.getName());
  
  public static void main( String[] args ) 
  {

    // java -Djava.util.logging.config.file=/home/user/config/logging.properties
    
    //Dynamic way, cannot call inside static method
    //System.out.println(getClass().getClassLoader().getResource("logging.properties"));
    
    // Static way
    System.out.println(App.class.getClassLoader().getResource("logging.properties"));

    LOGGER.setLevel(Level.SEVERE);
    LOGGER.severe("Info Log");
    LOGGER.warning("Info Log");
    LOGGER.info("Info Log");
    LOGGER.finest("Really not important");
    
    LOGGER.setLevel(Level.FINEST);
    LOGGER.severe("Info Log");
    LOGGER.warning("Info Log");
    LOGGER.info("Info Log");
    LOGGER.finest("Really not important");
    
    System.out.println( "Done!" );
  }
}
