package kz.marlen.spring_project;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init() {
        products.add(new Product(1L, "Продукт 1", 100.0));
        products.add(new Product(2L, "Продукт 2", 200.0));
        products.add(new Product(3L, "Продукт 3", 300.0));
        products.add(new Product(4L, "Продукт 4", 400.0));
        products.add(new Product(5L, "Продукт 5", 500.0));
    }

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }
}
