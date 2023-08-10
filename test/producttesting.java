import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import DAO.productDAO;
import model.ProductModel;

public class producttesting {
  private productDAO productDAO;

    @Before
    public void setUp() {
        productDAO = new productDAO();
    }

    @After
    public void tearDown() {
        // Clean up any resources or close database connection if required
    }

    @Test
    public void testAddProduct() {
        ProductModel product = new ProductModel(1, "Product1", "Category1", 10, 25.0);
        boolean success = productDAO.add(product);
        assertTrue(success);
    }

    @Test
    public void testUpdateProduct() {
        int productId = 1;
        ProductModel product = productDAO.getProductById(productId);
        assertNotNull(product);
        product.setProductname("Updated Product");
        boolean success = productDAO.update(product);
        assertTrue(success);
    }

    @Test
    public void testDeleteProduct() {
        int productId = 1;
        ProductModel product = new ProductModel(productId, "Product1", "Category1", 10, 25.0);
        productDAO.add(product);
        boolean success = productDAO.delete(product);
        assertTrue(success);
    }

   

//    @Test
//    public void testGetAllProducts() {
//        List<ProductModel> products = productDAO.getAllProducts();
//        assertNotNull(products);
//        // Since the database may contain other products as well,
//        // we can't assume the exact number of products retrieved.
//        // So, we only check if the list is not empty.
//        assertFalse(products.isEmpty());
//    }

    // Add more test cases as per your requirements


}