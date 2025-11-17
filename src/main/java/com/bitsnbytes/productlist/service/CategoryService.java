// Ye class ek "Service Layer" ka part hai —
// iska kaam Controller aur Repository ke beech mediator ka kaam karna hota hai.
// Business logic (actual kaam ka logic) yahi likha jata hai.
package com.bitsnbytes.productlist.service;

import com.bitsnbytes.productlist.dto.CategoryDTO;           // DTO import — frontend se ya frontend ko data dene ke liye
import com.bitsnbytes.productlist.entity.Category;           // Entity import — database ke object ke liye
import com.bitsnbytes.productlist.mapper.CategoryMapper;     // Mapper import — DTO <-> Entity conversion ke liye
import com.bitsnbytes.productlist.repository.CategoryRepository; // Repository import — database operations ke liye
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;               // Service annotation import

// @Service batata hai Spring Boot ko ki ye ek Service class hai
// Jisse Spring is class ka object automatically manage karega (Spring Bean bana dega)
@Service
@AllArgsConstructor
public class CategoryService {

    // CategoryRepository ka object declare kar rahe hain
    // Isse hum database ke saath CRUD operation kar sakte hain
    @Autowired
    private CategoryRepository categoryRepository;

    // ==================== CREATE CATEGORY ====================
    // Ye method ek nayi category create karta hai (POST API ke liye)
    // User se CategoryDTO aata hai (request body me)
    // Is DTO me sirf "name" aata hai (aur agar chahe to products ka list)
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {

        // Step 1️⃣: DTO → Entity conversion
        // Kyunki database sirf Entity objects samajhta hai
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);

        // Step 2️⃣: Entity ko database me save karwana
        // categoryRepository.save(category) use hota hai to save entity in database
        // Ye method save karne ke baad updated entity return karta hai (jisme ID bhi hoti hai)
        category = categoryRepository.save(category);

        // Step 3️⃣: Entity → DTO conversion (response ke liye)
        // Ab database se mil gaya updated entity (ID ke sath)
        // Use user ke liye readable DTO me convert kar rahe hain
        return CategoryMapper.toCategoryDTO(category);
    }
}
