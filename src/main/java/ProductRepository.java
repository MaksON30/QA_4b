import org.example.DatabaseException;

public class ProductRepository {
    public void addProduct(Product product) throws DatabaseException {
        throw new DatabaseException("Failed to add product to the database");
    }

    public Product getProductById(long productId) {
        return new Product(productId, "Dummy Product", 0.0);
    }

    public void updateProduct(Product product) {
        // Логіка для оновлення інформації про продукт в базі даних
    }

}
