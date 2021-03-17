package com.services;

import com.domain.entities.MaterialEntity;
import com.domain.entities.OrderEntity;
import com.repositories.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaterialService {
    private final MaterialRepository materialRepository;

    public MaterialEntity save(final MaterialEntity material) {
        return materialRepository.save(material);
    }

    public Optional<MaterialEntity> findById(final int id) {
        return materialRepository.findById(id);
    }

    public List<MaterialEntity> getAllMaterials() {
        return materialRepository.findAll();
    }

    public MaterialEntity create(final String name) {
        return save(MaterialEntity.builder()
                .name(name)
                .quantity(0)
                .build());
    }

    public void addQuantity(final int id, final int quantity) {
        Optional<MaterialEntity> materialEntity = findById(id);
        int q = 0;
        if (materialEntity.isPresent()) {
            q = materialEntity.get().getQuantity() + quantity;
        } else {
            return;
        }
        materialRepository.setQuantity(id, q);
    }

    public ResponseEntity subQuantity(final int id, final int quantity) {
        Optional<MaterialEntity> materialEntity = findById(id);
        int q = 0;
        if (materialEntity.isPresent()) {
            if (materialEntity.get().getQuantity() < quantity) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            } else {
                q = materialEntity.get().getQuantity() - quantity;
            }
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        materialRepository.setQuantity(id, q);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public void delete(final int id){
        materialRepository.deleteById(id);
    }
}
