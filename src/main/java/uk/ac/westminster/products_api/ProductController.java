package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

//    @GetMapping("/{id}")
//    public Product getById (@PathVariable Long id) {
//        return new Product(id, "Laptop", 999.99);
//    }

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping
    public Product addProduct(@RequestBody DigitalProduct product){
        return productService.addProduct(product) ;//this part is not working- Jakson cannot build an abstarct class
                                    //from JSON so the endpoint now is broken
                                    //Using DigitalProduct until a proper fix
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @GetMapping ("/search")
    public List<Product> search (@RequestParam String name){
        return productService.findByName(name);
    }

    @GetMapping("/summaries")
    public List<String> getSummaries(){
        return productService.getAllSummaries();
    }
}
