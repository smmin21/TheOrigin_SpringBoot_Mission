package dev.sternschnuppe.thirdbasic.repository;

import dev.sternschnuppe.thirdbasic.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
