package dev.sternschnuppe.thirdbasic.repository;

import dev.sternschnuppe.thirdbasic.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}
