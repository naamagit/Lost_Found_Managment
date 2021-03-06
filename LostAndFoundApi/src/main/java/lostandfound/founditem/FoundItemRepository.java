package lostandfound.founditem;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FoundItemRepository extends CrudRepository<FoundItem, Long> {

	public List<FoundItem> findByItemId(String itemId);

	public List<FoundItem> findByItemItemType(int itemType);

	public FoundItem findByItemItemTypeAndItemId(int itemType, String itemId);

	public List<FoundItem> findByUserUserId(String userId);

}
