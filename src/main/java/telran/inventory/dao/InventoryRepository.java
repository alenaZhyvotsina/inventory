package telran.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.inventory.model.InventoryItem;

public interface InventoryRepository extends JpaRepository<InventoryItem, Integer> {

}
