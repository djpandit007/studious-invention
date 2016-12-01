import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {
   @Test
   
   // Making sure JUnit is installed and running fine
   public void testAdd() {
      String str = "Junit is working fine";
      assertEquals("Junit is working fine",str);
   }
}