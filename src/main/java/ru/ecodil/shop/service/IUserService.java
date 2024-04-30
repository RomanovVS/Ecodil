package ru.ecodil.shop.service;

import ru.ecodil.shop.dao.model.UserDTO;
import ru.ecodil.shop.exception.UserAlreadyExistException;

public interface IUserService {
    UserDTO registerNewUserAccount(UserDTO userDto) throws UserAlreadyExistException;
}
