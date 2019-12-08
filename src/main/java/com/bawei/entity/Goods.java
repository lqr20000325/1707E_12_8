package com.bawei.entity;

public class Goods {
	private Integer id;
	private String name;
	private String date;
	private Integer num;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Goods(Integer id, String name, String date, Integer num) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.num = num;
	}
	public Goods() {
		super();
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", date=" + date + ", num=" + num + "]";
	}
	
}
