package dev.sternschnuppe.fifthbasic.repository;

import dev.sternschnuppe.fifthbasic.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
}
