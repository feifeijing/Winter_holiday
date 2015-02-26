package com.fei.bean;

public class Xiang {
	private String id;
	private String name;
	private String parent_id;
	private String order;
	public Xiang(){}
	public Xiang(String id, String name, String parent_id, String order) {
		super();
		this.id = id;
		this.name = name;
		this.parent_id = parent_id;
		this.order = order;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Xiang [id=" + id + ", name=" + name + ", parent_id="
				+ parent_id + ", order=" + order + "]";
	}
	
}
