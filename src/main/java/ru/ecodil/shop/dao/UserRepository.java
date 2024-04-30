package ru.ecodil.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ecodil.shop.dao.model.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Long> {

    public UserDTO findByEmail(String email);
}
