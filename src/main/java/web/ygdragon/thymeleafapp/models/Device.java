package web.ygdragon.thymeleafapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    private Long id;
    private String title;
    private String description;
    private Integer quantity;
}
