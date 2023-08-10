import static org.junit.Assert.*;
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

}