package telran.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InventoryItemDto {
	
	Integer itemNo;
	Integer code;
	String name;
	Integer amount;	

}
