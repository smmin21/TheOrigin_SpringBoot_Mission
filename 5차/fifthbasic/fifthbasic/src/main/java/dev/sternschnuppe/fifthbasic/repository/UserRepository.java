package dev.sternschnuppe.fifthbasic.repository;

import dev.sternschnuppe.fifthbasic.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}