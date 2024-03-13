import org.example.DatabaseException;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) throws DatabaseException {
        try {
            productRepository.addProduct(product);
        } catch (DatabaseException e) {
            // Обробка помилки при додаванні продукту в базу даних
            System.err.println("Failed to add product: " + e.getMessage());
            throw e;
        }
    }

    public Product getProductById(long productId) {
        return productRepository.getProductById(productId);
    }

    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

}
