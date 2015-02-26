package com.fei.bean;

import java.io.Serializable;

public class Shop implements Serializable{
	private String id;
	private String sn;
	private String name;
	private String thumb;
	private String img;
	private String market_price;
	private String shop_price;
	public Shop(){}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Shop(String id, String sn, String name, String thumb, String img,
			 String market_price, String shop_price) {
		super();
		this.id = id;
		this.sn = sn;
		this.name = name;
		this.thumb = thumb;
		this.img = img;
		
		this.market_price = market_price;
		this.shop_price = shop_price;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getMarket_price() {
		return market_price;
	}
	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}
	public String getShop_price() {
		return shop_price;
	}
	public void setShop_price(String shop_price) {
		this.shop_price = shop_price;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", sn=" + sn + ", name=" + name + ", thumb="
				+ thumb + ", img=" + img + ", price=" + ", market_price=" + market_price + ", shop_price="
				+ shop_price + "]";
	}
	
	
}
