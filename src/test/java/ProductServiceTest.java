import org.example.DatabaseException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Test
    void testAddProduct() {
        // Arrange
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductService productService = new ProductService(productRepository);
        Product product = new Product(1, "Test Product", 10.0);

        // Act
        productService.addProduct(product);

        // Assert
        verify(productRepository, times(1)).addProduct(product);
    }


    @Test
    void testAddProductWithExceptionHandling() {
        // Arrange
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductService productService = new ProductService(productRepository);
        Product product = new Product(1, "Test Product", 10.0);

        // Очікування винятку
        doThrow(DatabaseException.class).when(productRepository).addProduct(product);

        // Act and Assert
        assertThrows(DatabaseException.class, () -> productService.addProduct(product));
    }

    @Test
    void testGetProductById() {
        // Arrange
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductService productService = new ProductService(productRepository);
        long productId = 1;

        // Act
        productService.getProductById(productId);

        // Assert
        verify(productRepository, times(1)).getProductById(productId);
    }

    @Test
    void testUpdateProduct() {
        // Arrange
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductService productService = new ProductService(productRepository);
        Product product = new Product(1, "Test Product", 10.0);

        // Act
        productService.updateProduct(product);

        // Assert
        verify(productRepository, times(1)).updateProduct(product);
    }
}
