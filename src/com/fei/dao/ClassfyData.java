package com.fei.dao;

import java.util.ArrayList;
import java.util.List;

import com.fei.bean.Classfy;

public class ClassfyData {
	String[] data=new String[]{"����Ůװ","Ʒ����װ","��������","���õ���","�ֻ�����","���԰칫","������ױ","ĸӤƵ��","ʳƷ����","��ˮ����","�ҾӼҷ�"};
	public List<Classfy> getdata(){
		List<Classfy> list=new ArrayList<Classfy>();
		for(int i=0;i<data.length;i++){
			Classfy fy=new Classfy(data[i]);
			list.add(fy);
		}
		return list;
	}
}
