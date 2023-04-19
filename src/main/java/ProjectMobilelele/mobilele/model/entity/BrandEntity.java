package ProjectMobilelele.mobilele.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {
    
    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;
    
}
