package dev.sternschnuppe.fifthbasic.repository;

import dev.sternschnuppe.fifthbasic.entity.AreaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AreaRepository extends CrudRepository<AreaEntity, Long> {
    Optional<AreaEntity> findByLL(Double latitude, Double longitude);

}