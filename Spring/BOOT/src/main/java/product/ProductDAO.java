package product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("ProductDAO")
public interface ProductDAO {

	public List<ProductDTO> productList();

	public ProductDTO selectProduct(int code);

}
