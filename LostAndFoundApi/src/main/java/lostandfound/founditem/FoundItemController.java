package lostandfound.founditem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lostandfound.lostitem.LostItem;
import lostandfound.lostitem.LostItemService;

@RestController
public class FoundItemController {

	@Autowired
	private FoundItemService foundItemService;

	@Autowired
	private LostItemService lostItemService;

	@GetMapping("/founditems")
	public List<FoundItem> getAllFoundItems() {
		return foundItemService.getAllFoundItems();
	}

	@RequestMapping("/founditems/{itemType}")
	public List<FoundItem> getFoundItem(@PathVariable int itemType) {
		return foundItemService.getFoundItemByType(itemType);
	}

	@RequestMapping("/founditems/{itemType}/{itemId}")
	public FoundItem getFoundItem(@PathVariable int itemType, @PathVariable String itemId) {
		return foundItemService.getFoundItemByTypeAndId(itemType, itemId);
	}

	@RequestMapping("/users/{userId}/founditems")
	public List<FoundItem> getFoundItem(@PathVariable String userId) {
		return foundItemService.getFoundItemByUser(userId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/founditems")
	public ResponseEntity<?> addFoundItem(@RequestBody FoundItem foundItem) {
		try {
			foundItemService.addFoundItem(foundItem);
		} catch (Exception ex) {
			return new ResponseEntity<>("Found item could not be Reported ", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		LostItem lostItem = lostItemService.getLostItemByTypeAndId(foundItem.getItemType(), foundItem.getItemId());
		if (lostItem != null) {
			return new ResponseEntity<>(lostItem, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Found item reported successfully", HttpStatus.CREATED);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/founditems/{id}")
	public ResponseEntity<?> updateFoundItem(@RequestBody FoundItem foundItem, @PathVariable long id) {
		try {
			foundItemService.updateFoundItem(id, foundItem);
		} catch (Exception ex) {
			return new ResponseEntity<>("Found item could not be updated ", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>("Found item updated successfully", HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/founditems/{id}")
	public ResponseEntity<?> deleteFoundItem(@PathVariable long id) {
		try {
			foundItemService.deleteFoundItem(id);
		} catch (Exception ex) {
			return new ResponseEntity<>("Found item could not be deleted ", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<>("Found item deleted successfully", HttpStatus.OK);
	}

}
