package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@Autowired
	@Qualifier("ProductService")
	ProductService service;

	@RequestMapping("/productlist")
	public ModelAndView productList() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("productlist", service.productList());
		mv.setViewName("/mybatis/productlist");
		return mv;
	}

	@RequestMapping("product")
	public ModelAndView detailProduct(int code) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", service.selectProduct(code));
		mv.setViewName("/mybatis/detailproduct");
		return mv;
	}

}
