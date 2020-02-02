package lostandfound.founditem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoundItemService {
	@Autowired
	private FoundItemRepository foundItemRepository;

	public List<FoundItem> getAllFoundItems() {
		List<FoundItem> foundItems = new ArrayList<>();
		// convert into a list
		foundItemRepository.findAll().forEach(foundItems::add);
		return foundItems;
	}

	public List<FoundItem> getFoundItem(String itemId) {
		List<FoundItem> foundItems = new ArrayList<>();
		// convert into a list
		foundItemRepository.findByItemId(itemId).forEach(foundItems::add);
		return foundItems;
	}

	public List<FoundItem> getFoundItemByType(int itemType) {
		List<FoundItem> foundItems = new ArrayList<>();
		foundItemRepository.findByItemItemType(itemType).forEach(foundItems::add);
		return foundItems;
	}

	public FoundItem getFoundItemByTypeAndId(int itemType, String itemId) {
		return foundItemRepository.findByItemItemTypeAndItemId(itemType, itemId);
	}

	public List<FoundItem> getFoundItemByUser(String userId) {
		List<FoundItem> foundItems = new ArrayList<>();
		foundItemRepository.findByUserUserId(userId).forEach(foundItems::add);
		return foundItems;
	}

	public void addFoundItem(FoundItem foundItem) {
		foundItemRepository.save(foundItem);
	}

	public void updateFoundItem(long id, FoundItem foundItem) {
		foundItemRepository.save(foundItem);
	}

	public void deleteFoundItem(long id) {
		foundItemRepository.deleteById(id);
	}

}