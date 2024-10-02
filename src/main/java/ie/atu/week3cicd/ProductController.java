package ie.atu.week3cicd;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private List<Product> products = new ArrayList<>();
    public ProductController() {
        products.add(new Product("TV", "Made by Sony", 899, 100));
        products.add(new Product("Radio", "Made by Samsung", 99, 101));
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return products;
    }
    @PostMapping("/addProduct")
    public ResponseEntity<List> addProduct(@RequestBody Product product)
    {
        products.add(product);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<List> updateProduct(@PathVariable int id, @RequestBody Product product)
    {
        for(int i = 0; i< products.size(); i++){
            if(products.get(i).getId() == id){
                products.set(i, product);
            }
        }
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable long id){int num = (int) id;

        for (int count = 0; count < products.size(); count++)
        {
            if (products.get(count).getId() == num){products.remove(count);}
        }
        return ResponseEntity.ok(products);
    }
}


