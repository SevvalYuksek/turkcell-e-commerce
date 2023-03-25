package kodlama.io.turkcellecommerce.repository;

import kodlama.io.turkcellecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //Custom queries
}
