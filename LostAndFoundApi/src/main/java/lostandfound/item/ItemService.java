package lostandfound.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lostandfound.excpetion.NoDataFoundExcpetion;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<>();
		// convert into a list
		itemRepository.findAll().forEach(items::add);
		return items;
	}

	public Item getItem(int itemType) {
		return itemRepository.findById(itemType).orElseThrow(() -> new NoDataFoundExcpetion(itemType));
	}

	public void addItem(Item item) {
		itemRepository.save(item);
	}

	public void updateItem(int itemType, Item item) {
		itemRepository.save(item);
	}

	public void deleteItem(int itemType) {
		itemRepository.deleteById(itemType);
	}

}
