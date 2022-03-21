package dev.sternschnuppe.thirdbasic.jpa.repository;

import dev.sternschnuppe.thirdbasic.jpa.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
