import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import DAO.categoryDAO;
import model.categoryModel;

 

public class categorytesting {
  private categoryDAO categoryDAO;


    @Before
    public void setUp() {
        categoryDAO = new categoryDAO();
    }

    @Test
    public void testAddCategory() {
        categoryModel product = new categoryModel(1, "Category1", "Description1");
        boolean success = categoryDAO.add(product);
        assertTrue(success);
    }

 

    @Test
    public void testUpdateCategory() {
        categoryModel category = new categoryModel(1, "Category1", "Description1");
        assertNotNull(category);
        category.setCategoryName("Updated Category");
        boolean success = categoryDAO.update(category);
        assertTrue(success);
    }

 

    @Test
    public void testDeleteCategory() {
        categoryModel category = new categoryModel(1, "Category1", "Description1");
        categoryDAO.add(category);
        boolean success = categoryDAO.delete(category);
        assertTrue(success);
    }
}