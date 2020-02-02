package lostandfound.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/items")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}

	@RequestMapping("/items/{itemType}")
	public Item getItem(@PathVariable int itemType) {
		return itemService.getItem(itemType);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/items")
	public ResponseEntity<?> addItem(@RequestBody Item item) {
		try {
			itemService.addItem(item);
		} catch (Exception ex) {
			return new ResponseEntity<>("Item could not be created ", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>("Item created successfully ", HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/items/{itemType}")
	public ResponseEntity<?> updateItem(@RequestBody Item item, @PathVariable int itemType) {
		try {
			itemService.updateItem(itemType, item);
		} catch (Exception ex) {
			return new ResponseEntity<>("Item could not be updated ", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>("Item updated successfully ", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/items/{itemType}")
	public ResponseEntity<?> deleteItem(@PathVariable int itemType) {
		try {
			itemService.deleteItem(itemType);
		} catch (Exception ex) {
			return new ResponseEntity<>("Item could not be deleted ", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>("Item deleted successfully ", HttpStatus.OK);
	}
}
