package vn.oitstar.model;

public class CategoryModel {
	private int cate_id;
	private String cname;
	private String icons;
	public CategoryModel() {
		super();
	}
	public CategoryModel(int cate_id, String cname, String icons) {
		super();
		this.cate_id = cate_id;
		this.cname = cname;
		this.icons = icons;
	}
	public int getCate_id() {
		return cate_id;
	}
	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getIcons() {
		return icons;
	}
	public void setIcons(String icons) {
		this.icons = icons;
	}
	@Override
	public String toString() {
		return "CategoryModel [cate_id=" + cate_id + ", cname=" + cname + ", icons=" + icons + "]";
	}
	
}
