package com.ugurk.ProductManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping(path="/")
    public String viewHomePage(Model model) {
	
	List<Product> prodList = productService.listAll();
	model.addAttribute("prodList", prodList);
	return "index";
	
    }
    
    @GetMapping(path="/new")
    public String showNewProductForm(Model model) {
	Product product = new Product();
	model.addAttribute("product" , product); 
	return "new";
    }
    
    @PostMapping(path="/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
	productService.save(product);
	return "redirect:/";
    }
    
    @GetMapping(path="/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable int id) {
	ModelAndView modelandview = new ModelAndView("edit");
	
	Product product = productService.get(id);
	modelandview.addObject("product", product);
	
	return modelandview;
    }
	
    @GetMapping(path="/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
	productService.delete(id);
	return "redirect:/";
    }

}
