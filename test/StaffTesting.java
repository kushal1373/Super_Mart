import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import DAO.staffDAO;
import model.StaffModel;

public class StaffTesting {
  private staffDAO staffDAO;

    @Before
    public void setUp() {
        staffDAO = new staffDAO();
    }

    @Test
    public void testAddStaff() {
        StaffModel staff = new StaffModel(1, "Hari Shrestha", "Accountant", "Gender");
        boolean success = staffDAO.add(staff);
        assertTrue(success);
    }

    @Test
    public void testUpdateStaff() {
        StaffModel staff = new StaffModel(1, "Hari Shrestha", "Accountant", "Gender");
        assertNotNull(staff);
        staff.setstaffname("Updated Staff");
        boolean success = staffDAO.update(staff);
        assertTrue(success);
    }

    @Test
    public void testDeleteStaff() {
       StaffModel staff = new StaffModel(1, "Hari Shrestha", "Accountant", "Gender");
        staffDAO.add(staff);
        boolean success = staffDAO.delete(staff);
        assertTrue(success);
    }

}