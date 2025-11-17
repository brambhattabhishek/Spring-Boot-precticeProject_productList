package com.bitsnbytes.productlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CategoryDTO {
    private Long id; // create karne ke wakt hum is id ka use nahi karege kyo ki, read karne ke time per ye id show karega is liye hum ise comment karege, or create category ke time me use to hum karenge hi nahi kyo ki , caregory ka jo entity hai wo id create karega is liye
    private String name;
    private List<ProductDTO> products;
}
