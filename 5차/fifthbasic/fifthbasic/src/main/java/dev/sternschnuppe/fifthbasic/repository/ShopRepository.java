package dev.sternschnuppe.fifthbasic.repository;

import dev.sternschnuppe.fifthbasic.entity.ShopEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<ShopEntity, Long> {
}