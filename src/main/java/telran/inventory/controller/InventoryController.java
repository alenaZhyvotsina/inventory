package telran.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.inventory.dto.InventoryItemDto;
import telran.inventory.service.InventoryService;

@RestController
public class InventoryController {
	
	@Autowired
	InventoryService service;
	
	@PostMapping("/item")
	public boolean addItem(@RequestBody InventoryItemDto inventoryItemDto) {
		return service.addItem(inventoryItemDto);
	}
	
	@GetMapping("/item/{itemNo}")
	public InventoryItemDto getItem(@PathVariable Integer itemNo) {
		return service.getItem(itemNo);
	};
	
	@GetMapping("/items")
	public List<InventoryItemDto> itemsList(){
		return service.itemsList();
	}
	
	@DeleteMapping("/item/{itemNo}/{quantity}")
	public InventoryItemDto withdrawalQuantity(@PathVariable Integer itemNo, @PathVariable Integer quantity) {
		return service.withdrawalQuantity(itemNo, quantity);
	}
	
	@PutMapping("item/{itemNo}/{quantity}")
	public InventoryItemDto depositQuantity(@PathVariable Integer itemNo, @PathVariable Integer quantity) {
		return service.depositQuantity(itemNo, quantity);
	}
	
	@DeleteMapping("/item/{itemNo}")
	public InventoryItemDto deleteItem(@PathVariable Integer itemNo) {
		return service.deleteItem(itemNo);
	}

}
