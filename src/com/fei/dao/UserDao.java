package com.fei.dao;

import java.util.ArrayList;
import java.util.List;

import com.fei.bean.User;

public class UserDao {
	String[] names=new String[]{"ȫ������","�ҵ�Ǯ��","�ҵĹ�ע","�ҵ���Ϣ","�ҵ�ԤԼ","�����¼","������Ʒ","�˺��밲ȫ","����ܼ�","�������","���ķ���"};
	public List<User> getdata(){
		List<User> list=new ArrayList<User>();
		for(int i=0;i<names.length;i++){
			User u=new User(names[i]);
			list.add(u);
		}
		return list;
	}
}
