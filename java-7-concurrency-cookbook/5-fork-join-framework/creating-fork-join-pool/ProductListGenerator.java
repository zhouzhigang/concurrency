import java.util.List;
import java.util.ArrayList;

public class ProductListGenerator {

    public List<Product> generate(int size) {
        List<Product> ret = new ArrayList<Product>();
        for (int i = 0; i < size; i++) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }
}
