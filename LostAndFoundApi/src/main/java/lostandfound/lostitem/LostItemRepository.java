package lostandfound.lostitem;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LostItemRepository extends CrudRepository<LostItem, Long> {

	public List<LostItem> findByItemItemType(int itemType);

	public LostItem findByItemItemTypeAndItemId(int itemType, String itemId);

	public List<LostItem> findByUserUserId(String userId);

}
