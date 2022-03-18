package dev.sternschnuppe.thirdbasic.jpa.repository;

import dev.sternschnuppe.thirdbasic.jpa.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}
