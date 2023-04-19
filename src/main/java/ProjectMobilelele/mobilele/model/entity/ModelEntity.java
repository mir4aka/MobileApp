package ProjectMobilelele.mobilele.model.entity;

import ProjectMobilelele.mobilele.model.entity.enums.CategoryEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {
    
    private String name;
    
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;
    
    private String imageUrl;
    
    private int startYear;
    private int endYear;

}
