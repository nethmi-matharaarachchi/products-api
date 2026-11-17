package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L; //this remembers which ID to hand out next

    public ProductService(){
        products.add(new DigitalProduct(
                nextId++, "Clean code(E-book)", 29.30,
                "/downloads/clean-code.pdf", 4.2));

        products.add(new PhysicalProduct(
                nextId++, "27 inch monitor", 249.99,
                5.4, "61 cm x 41 cm x 12 cm"));
    }

    public List<Product> getAllProducts(){
        return products;

    }
    public Product addProduct (Product product){
        product.setId(nextId++); // uses the current value then increments it
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id){
        return products.stream()
                        .filter(p -> p.getId().equals(id))
                        .findFirst();
    }
    public void deleteProduct(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name){
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();

    }
}
