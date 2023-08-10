import view.*;
import controller.*;
import model.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    LoginView lview = new LoginView();
    LoginController controller = new LoginController(lview);
    LoginModel mod = new LoginModel("admin","admin","role");
    
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");

        lview.setUserName("admin");
        lview.setPassword("admin");
        lview.performLogin();

        Boolean expResult = false;
        Boolean result = controller.dataUser(mod);
        assertEquals(expResult, result);
    }
}