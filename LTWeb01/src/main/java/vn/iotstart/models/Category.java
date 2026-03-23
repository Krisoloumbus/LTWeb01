package vn.iotstart.models;

public class Category {
	
	private int cateid;
	private String catename;
	private String icon;
	
	public Category() {
		
	}
	public Category(int cateid, String catename, String icon) {
		this.cateid=cateid;
		this.catename=catename;
		this.icon=icon;
	}
	public int getId() {
		return cateid;
	}
	public void setId(int cateid) {
		this.cateid = cateid;
	}
	public String getName() {
		return catename;
	}
	public void setName(String catename) {
		this.catename = catename;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
