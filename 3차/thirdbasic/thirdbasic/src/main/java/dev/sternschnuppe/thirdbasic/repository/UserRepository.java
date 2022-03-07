package dev.sternschnuppe.thirdbasic.repository;

import dev.sternschnuppe.thirdbasic.entity.PostEntity;
import dev.sternschnuppe.thirdbasic.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
