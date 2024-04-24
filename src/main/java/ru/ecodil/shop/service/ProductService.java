package ru.ecodil.shop.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ecodil.shop.dao.ProductRepository;
import ru.ecodil.shop.dao.model.Product;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService (ProductRepository repository) {
        this.productRepository = repository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            return productRepository.save(updatedProduct);
        } else {
            createProduct(updatedProduct);
        }
        return null;
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findProductsByCategory(category);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
