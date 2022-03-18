package product;

import java.util.List;

public interface ProductService {

	public List<ProductDTO> productList();

	public ProductDTO selectProduct(int code);

}
