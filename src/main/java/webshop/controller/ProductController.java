package webshop.controller;

import java.io.File;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import webshop.domain.Product;

import webshop.services.ProductService;
import webstore.exception.NoProductFoundUnderCategoryException;
import webstore.exception.ProductNotFoundException;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";

	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {

		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}

	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		List<Product> listOfProducts = productService.getProductsByCategory(productCategory);
		if (listOfProducts == null || listOfProducts.isEmpty()) {
			throw new NoProductFoundUnderCategoryException();
		}
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return "products";
	}

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams,
			Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("newProduct", product);
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result,
			HttpServletRequest request) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException(
					"Wrong binding fields" + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		MultipartFile productImage = newProduct.getProductImage();
		String rootDir = request.getSession().getServletContext().getRealPath("/");
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDir + "resources\\images\\" + newProduct.getProductId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Error with uploading image", e);
			}
		}
		MultipartFile productInstruction = newProduct.getProductInstruction();
		rootDir = request.getSession().getServletContext().getRealPath("/");
		if (productInstruction != null && !productInstruction.isEmpty()) {
			try {
				productInstruction
						.transferTo(new File(rootDir + "resources\\pdf\\" + newProduct.getProductId() + ".pdf"));

			} catch (Exception e) {
				throw new RuntimeException("Error with uploading instruction", e);
			}
		}
		productService.addProduct(newProduct);
		return "redirect:/products";
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerError(HttpServletRequest req, ProductNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId",exception.getProductId());
		mav.addObject("exception",exception);
		mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}

}
