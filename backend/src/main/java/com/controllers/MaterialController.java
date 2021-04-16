package com.controllers;

import com.domain.entities.MaterialEntity;
import com.services.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MaterialController {
    private final MaterialService materialService;

    @GetMapping("api/v1/get_materials")
    public ResponseEntity<List<MaterialEntity>> getAllMaterials(){
        List<MaterialEntity> materials = materialService.getAllMaterials();
        if(materials.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(materials, HttpStatus.OK);
    }

    @PostMapping("api/v1/create_material")
    public ResponseEntity createMaterial(@RequestBody String name){
        MaterialEntity result = materialService.create(name);
        return new ResponseEntity(result, HttpStatus.ACCEPTED);
    }

    @PostMapping("api/v1/add_quantity/{id}/{quantity}")
    public ResponseEntity addQuantity(@PathVariable int id, @PathVariable int quantity){
        materialService.addQuantity(id, quantity);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping("api/v1/sub_quantity/{id}/{quantity}")
    public ResponseEntity subQuantity(@PathVariable int id, @PathVariable int quantity){
        return materialService.subQuantity(id, quantity);
    }

    @PostMapping("api/v1/delete_material/{id}")
    public ResponseEntity delete(@PathVariable int id){
        materialService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
