package telran.inventory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.inventory.dao.InventoryRepository;
import telran.inventory.dto.InventoryItemDto;
import telran.inventory.dto.exceptions.ItemNotFoundException;
import telran.inventory.dto.exceptions.NotEnoughQuantityAvailable;
import telran.inventory.dto.exceptions.WrongQuantity;
import telran.inventory.model.InventoryItem;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository repository;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	@Transactional
	public boolean addItem(InventoryItemDto inventoryItemDto) {
		if(repository.existsById(inventoryItemDto.getItemNo())) {
			return false;
		}
		if(inventoryItemDto.getAmount() < 0) {
			throw new WrongQuantity(inventoryItemDto.getAmount());
		}
		InventoryItem item = mapper.map(inventoryItemDto, InventoryItem.class);
		repository.save(item);
		return true;
	}

	@Override
	public InventoryItemDto getItem(Integer itemNo) {
		InventoryItem item = repository.findById(itemNo).orElseThrow(() -> new ItemNotFoundException());
		return mapper.map(item, InventoryItemDto.class);
	}

	@Override
	public List<InventoryItemDto> itemsList() {
		return repository.findAll().stream()
					.map(i -> mapper.map(i, InventoryItemDto.class))
					.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public InventoryItemDto withdrawalQuantity(Integer itemNo, Integer quantity) {
		InventoryItem item = repository.findById(itemNo).orElseThrow(() -> new ItemNotFoundException());
		if(item.getAmount() - quantity < 0) {
			throw new NotEnoughQuantityAvailable(quantity);
		}
		item.withdrawalQuantity(quantity);
		//repository.save(item);
		return mapper.map(item, InventoryItemDto.class);
	}

	@Override
	@Transactional
	public InventoryItemDto depositQuantity(Integer itemNo, Integer quantity) {
		InventoryItem item = repository.findById(itemNo).orElseThrow(() -> new ItemNotFoundException());
		item.addQuantity(quantity);
		//repository.save(item);
		return mapper.map(item, InventoryItemDto.class);
	}

	@Override
	@Transactional
	public InventoryItemDto deleteItem(Integer itemNo) {
		InventoryItem item = repository.findById(itemNo).orElseThrow(() -> new ItemNotFoundException());
		repository.delete(item);
		return mapper.map(item, InventoryItemDto.class);
	}

}
