package com.adminuiservice.dto;


import lombok.*;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ParentCategory {


    private Long id;

    private String parentCategoryTitle;

    private Long grandParenCategoryId;


}
