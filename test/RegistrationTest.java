import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import view.RegistrationView;
import controller.RegistrationController;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.RegistrationModel;

public class RegistrationTest {

    private RegistrationView rview;
    private RegistrationController controller;

    @Before
    public void setUp() {
        rview = new RegistrationView();
        controller = new RegistrationController(rview);
    }

    @Test
    public void testRegistrationModel() {
        String username = "tester";
        String password = "testpass";
        String fname = "test";
        String lname = "testlname";
        String email = "test@gmail.com";
        String gender = "Male";
        String role = "Manager";
        String confirmpassword = "testpass";

        RegistrationModel model = new RegistrationModel(username, password, fname, lname, email, gender, role, confirmpassword);

        assertEquals(username, model.getUsername());
        assertEquals(password, model.getPassword());
        assertEquals(fname, model.getFname());
        assertEquals(lname, model.getLname());
        assertEquals(email, model.getEmail());
        assertEquals(gender, model.getGender());
        assertEquals(role, model.getRole());
        assertEquals(confirmpassword, model.getconfirmPassword());
    }

    @Test
    public void testRegistrationController() {
        try {
            // Set the registration data in the view fields
            rview.setFirstName("test");
            rview.setLastName("testlname");
            rview.setEmail("test@gmail.com");
            rview.setUsername("tester");
            rview.setPassword("testpass");
            rview.setConfirmPassword("testpass");
            rview.setRole("Manager");
            rview.setGender("Male");
            // Simulate the sign-up button click
            rview.performSignup();
            
            
         Boolean expResult = true;
        Boolean result = controller.checkUser(rview.getUser());
        assertEquals(expResult, result);
    } catch (Exception ex) {
        Logger.getLogger(RegistrationTest.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}