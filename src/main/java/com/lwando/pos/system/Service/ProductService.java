package com.lwando.pos.system.Service;

import com.lwando.pos.system.modal.User;
import com.lwando.pos.system.payload.dto.ProductDTO;

import java.util.List;


public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO, User user) throws Exception;

    ProductDTO updateProduct(Long productId, ProductDTO productDTO, User user) throws Exception;

    void deleteProduct(Long productId, User user) throws Exception;

    List<ProductDTO> getAllProducts(User user);

    List<ProductDTO> getProductsByCategoryName(String categoryName, User user);

    List<ProductDTO> getProductsByStoreId(Long storeId);

    List<ProductDTO> searchProductsByKeyword(Long storeId, String keyword);

}
