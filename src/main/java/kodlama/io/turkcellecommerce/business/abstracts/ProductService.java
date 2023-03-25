package kodlama.io.turkcellecommerce.business.abstracts;

import kodlama.io.turkcellecommerce.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    Product add(Product product);
    Product update(int id, Product product);
    void delete(int id);
}
