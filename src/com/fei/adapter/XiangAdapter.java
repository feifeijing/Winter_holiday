package com.fei.adapter;

import java.util.List;

import com.example.winter_holiday.R;
import com.fei.adapter.ClassfyAdapter.ViewHolder;
import com.fei.bean.Xiang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class XiangAdapter extends BaseAdapter{
	Context context;
	List<Xiang> list;
	
	

	public XiangAdapter(Context context, List<Xiang> list) {
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
		TextView name,id,parent_id,order;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder vh=null;
		if(convertView==null){
			vh=new ViewHolder();
			convertView=LayoutInflater.from(context).inflate(R.layout.list_xiang, null);
			vh.name=(TextView) convertView.findViewById(R.id.name);
			vh.id=(TextView) convertView.findViewById(R.id.id);
			vh.parent_id=(TextView) convertView.findViewById(R.id.parent_id);
			vh.order=(TextView) convertView.findViewById(R.id.sort_order);
			convertView.setTag(vh);
		}else{
			vh=(ViewHolder) convertView.getTag();
		}
		Xiang xiang=list.get(position);
		vh.name.setText(xiang.getName());
		vh.id.setText(xiang.getId());
		vh.parent_id.setText(xiang.getParent_id());
		vh.order.setText(xiang.getOrder());
		return convertView;
	}

}
