// Ye class Product entity aur ProductDTO ke beech conversion (mapping) ka kaam karti hai.
// Entity: Database model hota hai (Product table ke corresponding).
// DTO: Client (frontend) ke sath data transfer karne ke liye use hota hai.
package com.bitsnbytes.productlist.mapper;

import com.bitsnbytes.productlist.dto.ProductDTO;   // DTO class import ki gayi hai
import com.bitsnbytes.productlist.entity.Category;  // Category entity import (kyunki product ek category me belong karta hai)
import com.bitsnbytes.productlist.entity.Product;   // Product entity import

public class ProductMapper {

    // ==================== ENTITY → DTO ====================
    // Ye method Product entity ko ProductDTO me convert karta hai.
    // Iska use tab hota hai jab hum database se product nikal kar frontend ko bhejna chahte hain.
    public static ProductDTO toProductDTO(Product product) {

        // Direct ek naya ProductDTO object bana rahe hain using constructor
        // Yahan entity ke fields ko DTO ke fields me map kar rahe hain
        return new ProductDTO(
                product.getId(),            // Database me auto-generated product ID
                product.getName(),          // Product ka naam
                product.getDescription(),   // Product ka description
                product.getPrice(),         // Product ki price
                product.getCategory().getId() // Product kis category me belong karta hai (Category ki ID)
        );
        // Yahan humne sirf Category ki ID bheji hai, pura Category object nahi,
        // kyunki frontend ko sirf ID chahiye hoti hai (response ko lightweight rakhne ke liye)
    }

    // ==================== DTO → ENTITY ====================
    // Ye method ProductDTO ko Product entity me convert karta hai.
    // Iska use tab hota hai jab frontend se product create/update request aati hai.
    public static Product toProductEntity(ProductDTO productDTO , Category category) {

        // Naya Product entity object bana rahe hain
        Product product = new Product();

        // product.setId(productDTO.getId());
        // 👆 ye comment isliye hai kyunki id database me AUTO-GENERATED hoti hai (Primary Key)
        // isliye manually set karne ki jarurat nahi hai jab naya product create ho raha hai.

        // DTO me se product name set kar rahe hain
        product.setName(productDTO.getName());

        // DTO me se product description set kar rahe hain
        product.setDescription(productDTO.getDescription());

        // DTO me se product price set kar rahe hain
        product.setPrice(productDTO.getPrice());

        // Yahan Category entity set kar rahe hain (jo service layer me pehle fetch ki gayi hogi)
        // Taaki Product aur Category ke beech relationship maintain rahe (ManyToOne relation)
        product.setCategory(category);

        // Final entity object return kar rahe hain jise database me save kiya ja sake
        return product;
    }
}
