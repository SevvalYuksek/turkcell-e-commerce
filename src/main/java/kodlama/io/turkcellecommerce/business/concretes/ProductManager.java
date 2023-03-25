package kodlama.io.turkcellecommerce.business.concretes;

import kodlama.io.turkcellecommerce.business.abstracts.ProductService;
import kodlama.io.turkcellecommerce.entities.Product;
import kodlama.io.turkcellecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return repository.save(product);
    }


    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        checkIfProductExists(id);
        product.setId(id);
        return repository.save(product);
    }

    @Override
    public void delete(int id) {
        checkIfProductExists(id);
        repository.deleteById(id);
    }
    private void validateProduct(Product product){
        checkIfUnitPriceValid(product);
        checkIfQuantityValid(product);
        checkIfDescriptionLengthValid(product);
    }

    //İş kuralları
    private void checkIfUnitPriceValid(Product product){
        if (product.getUnitPrice()<=0) throw new IllegalArgumentException("Price cannot be less than or equal zero");
    }
    private static void checkIfQuantityValid(Product product) {
        if (product.getQuantity()<0) throw new IllegalArgumentException("Quantitiy cannot be less than  zero");
    }

    private static void checkIfDescriptionLengthValid(Product product) {
        if (product.getDescription().length()<10 || product.getDescription().length()>50)
            throw new IllegalArgumentException("Description length must be between 10 and 50 characters");
    }

    private void checkIfProductExists(int id) {
        if (!repository.existsById(id)) throw new RuntimeException("Böyle bir ürün mevcut değil.");
    }
}
