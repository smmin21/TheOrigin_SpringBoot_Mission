package dev.sternschnuppe.fifthbasic.repository;

import dev.sternschnuppe.fifthbasic.entity.ShopReviewEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopReviewRepository extends CrudRepository<ShopReviewEntity, Long> {
}