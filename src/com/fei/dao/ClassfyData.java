package com.fei.dao;

import java.util.ArrayList;
import java.util.List;

import com.fei.bean.Classfy;

public class ClassfyData {
	String[] data=new String[]{"潮流女装","品牌男装","内衣配饰","家用电器","手机数码","电脑办公","个护化妆","母婴频道","食品生鲜","酒水饮料","家居家纺"};
	public List<Classfy> getdata(){
		List<Classfy> list=new ArrayList<Classfy>();
		for(int i=0;i<data.length;i++){
			Classfy fy=new Classfy(data[i]);
			list.add(fy);
		}
		return list;
	}
}
