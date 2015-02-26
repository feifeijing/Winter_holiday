package com.fei.adapter;

import java.util.List;

import com.example.winter_holiday.R;
import com.fei.bean.Classfy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ClassfyAdapter extends BaseAdapter{
	Context context;
	List<Classfy> list;
	
	public ClassfyAdapter(Context context, List<Classfy> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	class ViewHolder{
		TextView classfy; 
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder vh;
		if(convertView==null){
			vh=new ViewHolder();
			convertView=LayoutInflater.from(context).inflate(R.layout.list_classfy, null);
			vh.classfy=(TextView) convertView.findViewById(R.id.classfy);
			convertView.setTag(vh);
		}else{
			vh=(ViewHolder) convertView.getTag();
		}
		Classfy fy=list.get(position);
		vh.classfy.setText(fy.getClassfy());
		return convertView;
	}

}
