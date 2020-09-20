package telran.inventory.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class InventoryItem {
	@Id
	Integer itemNo;
	Integer code;
	String name;
	Integer amount;
	
	public void addQuantity(int quantity) {
		amount += quantity;
	}
	
	public void withdrawalQuantity(int quantity) {
		if(quantity <= amount) {
			amount -= quantity;
		}
	}
	

}
