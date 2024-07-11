package kz.marlen.spring_project;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private final List<Product> items = new ArrayList<>();
    private final ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Long productId) {
        productRepository.findById(productId).ifPresent(items::add);
    }

    public void removeProduct(Long productId) {
        items.removeIf(product -> product.getId().equals(productId));
    }

    public List<Product> getItems() {
        return items;
    }
}
