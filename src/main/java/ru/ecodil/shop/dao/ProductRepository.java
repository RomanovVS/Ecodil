package ru.ecodil.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ecodil.shop.dao.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getProductById(Long id);

    List<Product> findProductsByCategory(String category);

    void deleteProductById(Long id);
}
