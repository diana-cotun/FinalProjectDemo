package ro.sda.java64.finalprojectdemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDto {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private String description;
    private String url;
}
