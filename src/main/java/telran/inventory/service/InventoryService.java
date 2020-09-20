package telran.inventory.service;

import java.util.List;

import telran.inventory.dto.InventoryItemDto;

public interface InventoryService {
	
	boolean addItem(InventoryItemDto inventoryItemDto);
	
	InventoryItemDto getItem(Integer itemNo);
	
	List<InventoryItemDto> itemsList();
	
	InventoryItemDto withdrawalQuantity(Integer itemNo, Integer quantity);
	
	InventoryItemDto depositQuantity(Integer itemNo, Integer quantity);
	
	InventoryItemDto deleteItem(Integer itemNo);

}
