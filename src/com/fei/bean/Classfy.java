package com.fei.bean;

public class Classfy {
	private String classfy;
	public Classfy(){}
	public Classfy(String classfy) {
		super();
		this.classfy = classfy;
	}
	public String getClassfy() {
		return classfy;
	}
	public void setClassfy(String classfy) {
		this.classfy = classfy;
	}
	@Override
	public String toString() {
		return "Classfy [classfy=" + classfy + "]";
	}
	
}
