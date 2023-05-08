package ProjectMobilelele.mobilele.service;

import ProjectMobilelele.mobilele.model.DTO.UserLoginDTO;
import ProjectMobilelele.mobilele.model.entity.UserEntity;
import ProjectMobilelele.mobilele.repository.UserRepository;
import ProjectMobilelele.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }
    
    
    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(userLoginDTO.getUsername());
        
        if (userOpt.isEmpty()) {
            LOGGER.info("User with name [{}] not found.", userLoginDTO.getUsername());
            return false;
        }
        
        var rawPassword = userLoginDTO.getPassword();
        var encodedPassword = userOpt.get().getPassword();
        
        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);
        
        if (success) {
            login(userOpt.get());
        } else {
            logOut();
        }
        
        return success;
    }
    
    private void login(UserEntity userEntity) {
        currentUser.setLoggedIn(true);
        currentUser.setName(userEntity.getFirstName() + " " + userEntity.getLastName());
    }
    
    public void logOut() {
        currentUser.clear();
    }
}
