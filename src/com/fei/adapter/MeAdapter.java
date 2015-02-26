package com.fei.adapter;

import java.util.List;

import com.example.winter_holiday.R;
import com.fei.bean.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MeAdapter extends BaseAdapter{
	Context context;
	List<User> list;
	
	public MeAdapter(Context context, List<User> list) {
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
		TextView function;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder vh=null;
		if(convertView==null){
			vh=new ViewHolder();
			convertView=LayoutInflater.from(context).inflate(R.layout.list_me, null);
			vh.function=(TextView) convertView.findViewById(R.id.function);
			convertView.setTag(vh);
		}else{
			vh=(ViewHolder) convertView.getTag();
		}
		User u=list.get(position);
		vh.function.setText(u.getName());
		return convertView;
	}

}
