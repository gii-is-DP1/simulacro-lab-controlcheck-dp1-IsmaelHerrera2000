package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductTypeFormatter implements Formatter<ProductType>{

	ProductService producService;

    @Override
    public String print(ProductType object, Locale locale) {
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        ProductType productType = producService.getProductType(text);
        if (productType == null) {
            throw new ParseException("Product type not found: " + text, 0);
        }
        return productType;
    }
    
}
