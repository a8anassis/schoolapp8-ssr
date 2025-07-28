package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.core.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.schoolapp.dto.UserInsertDTO;
import gr.aueb.cf.schoolapp.mapper.Mapper;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.model.auth.Role;
import gr.aueb.cf.schoolapp.repository.RoleRepository;
import gr.aueb.cf.schoolapp.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Mapper mapper;
    private final RoleRepository roleRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void saveUser(UserInsertDTO userInsertDTO) throws EntityAlreadyExistsException {
        try {
            if (userRepository.findByUsername(userInsertDTO.getUsername()).isPresent()) {
                throw new EntityAlreadyExistsException("User",
                        "User with username: " + userInsertDTO.getUsername() + " already exists.");
            }
            User user = mapper.mapToUserEntity(userInsertDTO);
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            Role role = roleRepository.findById(userInsertDTO.getRoleId()).orElse(null);
            user.setRole(role);
            userRepository.save(user);
            log.info("Save succeeded for user with username={}", userInsertDTO.getUsername());
        } catch (EntityAlreadyExistsException e) {
            log.error("Save failed for user with username={}. User already exists.", userInsertDTO.getUsername(), e);
            throw e;
        }
    }
}
