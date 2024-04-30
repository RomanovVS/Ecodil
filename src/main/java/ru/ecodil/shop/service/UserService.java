package ru.ecodil.shop.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ecodil.shop.dao.UserRepository;
import ru.ecodil.shop.dao.model.UserDTO;
import ru.ecodil.shop.exception.UserAlreadyExistException;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO registerNewUserAccount(UserDTO userDto) throws UserAlreadyExistException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an registered account with that email address: "
                    + userDto.getEmail());
        }

        UserDTO user = new UserDTO();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRoles("client");

        return repository.save(user);
    }


    private boolean emailExists(String email) {
        return repository.findByEmail(email) != null;
    }
}
