package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/product")
public class ProductController {
    private final String  PRODUCTS_LISTING_VIEW="products/productsList";
    private final String PRODUCTS_FORM="products/createOrUpdateProductForm";
    
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService service){
        this.productService=service;
    }
   
    @Transactional(readOnly = true)
    @GetMapping("/")
    public ModelAndView showProducts(){
        ModelAndView result=new ModelAndView(PRODUCTS_LISTING_VIEW);
        result.addObject("products", productService.getAllProducts());
        return result;
    }
    
    //Ejercicio 9 y 10
    @GetMapping("/create")
    public ModelAndView createProduct() {
        ModelAndView mav = new ModelAndView(PRODUCTS_FORM);
        mav.addObject("product", new Product());
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView processCreationForm(@Valid Product product, BindingResult result) {
        ModelAndView mav;
        if (result.hasErrors()) {
            mav = new ModelAndView(PRODUCTS_FORM);
            mav.addObject("product", product);
            mav.addObject("types", productService.findAllProductTypes());
        } else {
            this.productService.save(product);
            mav = new ModelAndView("welcome");
        }
        return mav;
    }
    //Si no no sale
    @ModelAttribute("productTypes")
    public List<ProductType> populateProductTypes() {
        return this.productService.findAllProductTypes();
    }

}
