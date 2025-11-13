// CategoryMapper class ka kaam DTO aur Entity ke beech data ko convert (map) karna hai.
// Ye basically ek "bridge" jaisa kaam karta hai.
package com.bitsnbytes.productlist.mapper;

import com.bitsnbytes.productlist.dto.CategoryDTO; // DTO (Data Transfer Object) ko import kar rahe hain
import com.bitsnbytes.productlist.entity.Category; // Entity (Database model) ko import kar rahe hain

public class CategoryMapper {

    // ==================== ENTITY → DTO ====================
    // Ye method Entity object (Category) ko DTO object (CategoryDTO) me convert karta hai
    public static CategoryDTO toCategoryDTO(Category category){

        // Null check kar rahe hain — agar input null hua to NullPointerException se bacha sake
        if(category == null){
            return null;
        }

        // Naya CategoryDTO object bana rahe hain — jisme hum entity se values copy karenge
        CategoryDTO categoryDTO = new CategoryDTO();

        // Entity ke 'id' ko DTO ke 'id' me set kar rahe hain
        // Matlab database se jo id mili hai, wo DTO me chali gayi (API response ke liye)
        categoryDTO.setId(category.getId());

        // Entity ke 'name' ko DTO ke 'name' me set kar rahe hain
        // Yani category ka naam bhi DTO me copy kar diya
        categoryDTO.setName(category.getName());

        categoryDTO.setProducts(category.getProducts().stream()
                .map(ProductMapper::toProductDTO).toList());


        // Ab hum pura DTO object return kar rahe hain
        // (Ye step missing tha tumhare code me — isliye add kar rahe hain)
        return categoryDTO;
    }

    // ==================== DTO → ENTITY ====================
    // Ye method DTO object (CategoryDTO) ko Entity object (Category) me convert karta hai
    public static Category toCategoryEntity(CategoryDTO categoryDTO) {

        // Naya Category (Entity) object bana rahe hain — jisme hum DTO se values copy karenge
        Category category = new Category();

        // DTO ke 'name' ko Entity ke 'name' me set kar rahe hain
        // Jab client se request me category name aata hai, to wo yahan set hota hai
        category.setName(categoryDTO.getName());

        // Agar DTO me 'id' bhi hoti aur update karna hota, to hum yahan set kar sakte the:
        // category.setId(categoryDTO.getId());
        // Lekin yahan hum nayi category bana rahe hain isliye id nahi set ki gayi

        // Ab hum pura entity object return kar rahe hain
        // Jisse service ya repository database me save kar sake
        return category;
    }

}
