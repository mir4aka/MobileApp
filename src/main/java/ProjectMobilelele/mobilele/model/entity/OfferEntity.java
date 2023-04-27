package ProjectMobilelele.mobilele.model.entity;

import ProjectMobilelele.mobilele.model.entity.enums.EngineEnum;
import ProjectMobilelele.mobilele.model.entity.enums.TransmissionEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class OfferEntity{
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;
    
    private String imageUrl;
    
    private int mileage;
    
    @Column(nullable = false)
    private BigDecimal price;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;
    
    @Column(nullable = false)
    private int year;
    
    @ManyToOne
    private ModelEntity model;
    
    @ManyToOne
    private UserEntity seller;
    
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public EngineEnum getEngine() {
        return engine;
    }
    
    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }
    
    public String getImageUrl() {
        return imageUrl;
    }
    
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public int getMileage() {
        return mileage;
    }
    
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public TransmissionEnum getTransmission() {
        return transmission;
    }
    
    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public ModelEntity getModel() {
        return model;
    }
    
    public void setModel(ModelEntity model) {
        this.model = model;
    }
    
    public UserEntity getSeller() {
        return seller;
    }
    
    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }
    
    @Override
    public String toString() {
        return "OfferEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                ", model=" + model +
                ", seller=" + seller +
                '}';
    }
}
