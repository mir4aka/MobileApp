package ProjectMobilelele.mobilele.model.entity;

import ProjectMobilelele.mobilele.model.entity.enums.UserRoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoleEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public UserRoleEnum getRole() {
        return role;
    }
    
    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
