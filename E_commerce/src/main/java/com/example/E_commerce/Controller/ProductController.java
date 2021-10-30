package com.example.E_commerce.Controller;

import com.example.E_commerce.BaseReponse.BaseResponsePro;
import com.example.E_commerce.BaseReponse.PageResponse;
import com.example.E_commerce.DTO.ProductDTO;
import com.example.E_commerce.Entity_or_Model.Product;
import com.example.E_commerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public BaseResponsePro<Product> addProduct(@RequestBody ProductDTO productDTO){
        BaseResponsePro<Product> baseResponse;
        baseResponse = BaseResponsePro.<Product>builder().Data(productService.AddProduct(productDTO)).build();
        return baseResponse;
    }

    @PutMapping("/update")
    public BaseResponsePro<Optional<Product>> updateByProductId(@RequestBody ProductDTO productDTO){
        BaseResponsePro<Optional<Product>> baseResponse;
        baseResponse = BaseResponsePro.<Optional<Product>>builder().Data(productService.UpdateByProductId(productDTO)).build();
        return  baseResponse;
    }

    @GetMapping("/getAll")
    public BaseResponsePro<List<Product>> listAll(){
        BaseResponsePro<List<Product>> baseResponse;
        baseResponse = BaseResponsePro.<List<Product>>builder().Data(productService.ListAll()).build();
        return  baseResponse;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return  "Success";
    }

    @GetMapping("/{offset}/{pageSize}/{category}")
    private PageResponse<Product> productPagination(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String category){
        return productService.productPagination(offset, pageSize, category);

    }
}

