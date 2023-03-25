package kodlama.io.turkcellecommerce.repository.concretes;

import kodlama.io.turkcellecommerce.entities.concretes.Product;
import kodlama.io.turkcellecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    List<Product> products;

    public InMemoryProductRepository(){
        products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 10, 155000, "MSI TITAN GT77HX 13VI-069TR Intel Core i9 128GB" ));
        products.add(new Product(2, "Süpürge", 20, 15000, "Dyson V15 Detect Absolute Kablosuz Süpürge" ));
        products.add(new Product(3, "Kahvaltı Takımı", 8, 15000, "Porland Azelya Ikram ve Kahvaltı Takımı 18 Parça" ));
        products.add(new Product(4, "Spatula Seti", 25, 150, "Isıya Dayanıklı Silikon Spatula Seti 6 Parça" ));
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        return products.get(id - 1);
    }

    @Override
    public Product add(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product update(int id, Product product) {
        return products.set(id-1, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id - 1);
    }
}
