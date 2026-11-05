package com.tecsup.minishop.service;

import com.tecsup.minishop.model.Product;
import com.tecsup.minishop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Contiene las reglas de negocio para gestionar productos.
@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Spring proporciona el repositorio mediante el constructor.
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        // Valida el precio y el stock antes de guardar.
        if (product.getPrice() <= 0) {
            throw new IllegalArgumentException(
                    "El precio debe ser mayor a cero"
            );
        }

        if (product.getStock() < 0) {
            throw new IllegalArgumentException(
                    "El stock no puede ser negativo"
            );
        }

        return productRepository.save(product);
    }

    // Consulta todos los productos registrados.
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Busca un producto por ID y lanza una excepción si no existe.
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Producto no encontrado con id: " + id
                ));
    }
}