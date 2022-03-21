package dev.sternschnuppe.thirdbasic.jpa.repository;

import dev.sternschnuppe.thirdbasic.jpa.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
