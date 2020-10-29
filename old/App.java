package yaoyaozii;

public class App 
{
  public static void main( String[] args ) 
  {
    // YLog yl = new YLog();
    // yl.run();

    DVdo dv = new DVdo();
    try {
      dv.run();
    } catch (com.google.api.client.http.HttpResponseException e) {
      System.err.println(e.getMessage());
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }
}
