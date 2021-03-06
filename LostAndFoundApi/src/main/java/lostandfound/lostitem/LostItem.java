package lostandfound.lostitem;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lostandfound.location.Location;
import lostandfound.user.User;
import lostandfound.item.Item;

@Entity
@Table(name = "LOST_ITEMS")

public class LostItem {
	@Id
	@GeneratedValue
	@Column
	private long lostId;

	@ManyToOne
	@JoinColumn(name = "itemType", nullable = false, foreignKey = @ForeignKey(name = "Fk_lost_item_type"))
	private Item item;
	@Column(length = 9)
	private String itemId;
	@Column(columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lostDate;
	@Embedded
	private Location location;
	@Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date reportedDate;

	@ManyToOne
	@JoinColumn(name = "UserId", nullable = false, foreignKey = @ForeignKey(name = "Fk_lost_user_id"))
	private User user;

	public LostItem(long lostId, String itemId, Date lostDate, Date reportedDate) {
		super();
		this.lostId = lostId;
		this.itemId = itemId;
		this.lostDate = lostDate;
		this.reportedDate = reportedDate;
	}

	public LostItem() {

	}

	public long getLostId() {
		return lostId;
	}

	public void setLostId(long lostId) {
		this.lostId = lostId;
	}

	public Item getItem() {
		return item;
	}

	public int getItemType() {
		return item.getItemType();
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Date getLostDate() {
		return lostDate;
	}

	public void setLostDate(Date lostDate) {
		this.lostDate = lostDate;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LostItem [lostId=" + lostId + ", itemId=" + itemId + ", lostDate=" + lostDate + ", reportedDate="
				+ reportedDate + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LostItem other = (LostItem) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (lostDate == null) {
			if (other.lostDate != null)
				return false;
		} else if (!lostDate.equals(other.lostDate))
			return false;
		if (lostId != other.lostId)
			return false;
		if (reportedDate == null) {
			if (other.reportedDate != null)
				return false;
		} else if (!reportedDate.equals(other.reportedDate))
			return false;
		return true;
	}

}