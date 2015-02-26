package com.fei.dao;

import java.util.ArrayList;
import java.util.List;

import com.fei.bean.User;

public class UserDao {
	String[] names=new String[]{"全部订单","我的钱包","我的关注","我的消息","我的预约","浏览记录","评价商品","账号与安全","服务管家","意见反馈","贴心服务"};
	public List<User> getdata(){
		List<User> list=new ArrayList<User>();
		for(int i=0;i<names.length;i++){
			User u=new User(names[i]);
			list.add(u);
		}
		return list;
	}
}
