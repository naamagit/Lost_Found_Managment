package lostandfound.lostitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lostandfound.founditem.FoundItem;
import lostandfound.founditem.FoundItemService;

@RestController
public class LostItemController {
	@Autowired
	private LostItemService lostItemService;

	@Autowired
	private FoundItemService foundItemService;

	@RequestMapping("/lostitems")
	public List<LostItem> getAllLostItems() {
		return lostItemService.getAllLostItems();
	}

	@RequestMapping("/lostitems/{itemType}")
	public List<LostItem> getLostItem(@PathVariable int itemType) {
		return lostItemService.getLostItemByType(itemType);
	}

	@RequestMapping("/lostitems/{itemType}/{itemId}")
	public LostItem getLostItem(@PathVariable int itemType, @PathVariable String itemId) {
		return lostItemService.getLostItemByTypeAndId(itemType, itemId);
	}

	@RequestMapping("/users/{userId}/lostitems")
	public List<LostItem> getLostItem(@PathVariable String userId) {
		return lostItemService.getLostItemByUser(userId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/lostitems")
	public ResponseEntity<?> addLostItem(@RequestBody LostItem lostItem) {
		try {
			lostItemService.addLostItem(lostItem);
		} catch (Exception ex) {
			return new ResponseEntity<>("Lost item could not be Reported ", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		FoundItem foundItem = foundItemService.getFoundItemByTypeAndId(lostItem.getItemType(), lostItem.getItemId());
		if (foundItem != null) {
			return new ResponseEntity<>(foundItem, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Lost item reported successfully", HttpStatus.CREATED);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/lostitems/{id}")
	public ResponseEntity<?> updateLostItem(@RequestBody LostItem lostItem, @PathVariable long id) {
		try {
			lostItemService.updateLostItem(id, lostItem);
		} catch (Exception ex) {
			return new ResponseEntity<>("Lost item could not be updated ", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>("Lost item updated successfully", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/lostitems/{id}")
	public ResponseEntity<?> deleteLostItem(@PathVariable long id) {
		try {
			lostItemService.deleteLostItem(id);
		} catch (Exception ex) {
			return new ResponseEntity<>("Lost item could not be deleted ", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>("Lost item deleted successfully", HttpStatus.OK);
	}
}
