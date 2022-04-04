package dev.sternschnuppe.fifthbasic.controller;

import dev.sternschnuppe.fifthbasic.controller.dto.AreaDto;
import dev.sternschnuppe.fifthbasic.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("area")
public class AreaController {
    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @PostMapping
    public ResponseEntity<AreaDto> createArea(@RequestBody AreaDto dto){
        return ResponseEntity.ok(this.areaService.createArea(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<AreaDto> readArea(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.areaService.readArea(id));
    }

    @GetMapping
    public ResponseEntity<Collection<AreaDto>> readAreaAll() {
        return ResponseEntity.ok(this.areaService.readAreaAll());
    }

    @GetMapping("{latitude}/{longitude}")
    public ResponseEntity<AreaDto> readAreaLL(
            @PathVariable("latitude") Double latitude,
            @PathVariable("longitude" ) Double longitude
    ){
        return ResponseEntity.ok(this.areaService.readAreaLL(latitude, longitude));
    }
}