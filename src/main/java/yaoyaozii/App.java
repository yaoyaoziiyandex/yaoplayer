package yaoyaozii;

public class App 
{
  public static void main( String[] args ) 
  {
    System.out.println(App.class.getClassLoader().getResource("logging.properties"));
    YLog yl = new YLog();
    yl.run();
  }
}
