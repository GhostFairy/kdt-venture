package product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	@Qualifier("ProductDAO")
	ProductDAO dao;

	@Override
	public List<ProductDTO> productList() {
		return dao.productList();
	}

	@Override
	public ProductDTO selectProduct(int code) {
		return dao.selectProduct(code);
	}

}
