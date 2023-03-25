package kodlama.io.turkcellecommerce.business.concretes;

import kodlama.io.turkcellecommerce.business.abstracts.ProductService;
import kodlama.io.turkcellecommerce.entities.concretes.Product;
import kodlama.io.turkcellecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return repository.add(product);
    }


    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        return repository.update(id, product);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
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

}
