package lostandfound.founditem;

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
import javax.validation.constraints.NotNull;

import lostandfound.location.Location;
import lostandfound.user.User;
import lostandfound.item.Item;

@Entity
@Table(name = "FOUND_ITEMS")

public class FoundItem {
	@Id
	@GeneratedValue
	@Column
	private long foundId;

	@ManyToOne
	@JoinColumn(name = "itemType", nullable = false, foreignKey = @ForeignKey(name = "Fk_found_item_type"))
	private Item item;
	@Column(length = 9)
	@NotNull
	private String itemId;
	@Column(columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date foundDate;
	@Embedded
	private Location location;
	@Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date reportedDate;

	@ManyToOne
	@JoinColumn(name = "UserId", nullable = false, foreignKey = @ForeignKey(name = "Fk_found_user_id"))
	private User user;

	public FoundItem(long foundId, String itemId, Date foundDate, Date reportedDate) {
		super();
		this.foundId = foundId;
		this.itemId = itemId;
		this.foundDate = foundDate;
		this.reportedDate = reportedDate;
	}

	public FoundItem() {

	}

	public long getFoundId() {
		return foundId;
	}

	public void setFoundId(long foundId) {
		this.foundId = foundId;
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

	public Date getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(Date foundDate) {
		this.foundDate = foundDate;
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
		return "FoundItem [foundId=" + foundId + ", itemId=" + itemId + ", foundDate=" + foundDate + ", reportedDate="
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
		FoundItem other = (FoundItem) obj;
		if (foundDate == null) {
			if (other.foundDate != null)
				return false;
		} else if (!foundDate.equals(other.foundDate))
			return false;
		if (foundId != other.foundId)
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (reportedDate == null) {
			if (other.reportedDate != null)
				return false;
		} else if (!reportedDate.equals(other.reportedDate))
			return false;
		return true;
	}

}