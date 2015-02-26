package com.fei.adapter;

import java.util.List;

import com.example.winter_holiday.R;
import com.example.winter_holiday.ShopActivity;
import com.fei.bean.Shop;

import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeAdapter extends BaseAdapter{
	Context context;
	List<Shop> list;
	
	public HomeAdapter(Context context, List<Shop> list) {
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
		ImageView img;
		TextView name,sn,price;
		Button data;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder vh=null;
		if(convertView==null){
			vh=new ViewHolder();
			convertView=LayoutInflater.from(context).inflate(R.layout.list_home, null);
			vh.img=(ImageView) convertView.findViewById(R.id.img);
			vh.sn=(TextView) convertView.findViewById(R.id.sn);
			vh.price=(TextView) convertView.findViewById(R.id.price);
			vh.name=(TextView) convertView.findViewById(R.id.name);
			vh.data=(Button) convertView.findViewById(R.id.data);
			convertView.setTag(vh);
			
		}else{
			vh=(ViewHolder) convertView.getTag();
		}
		final Shop shop=list.get(position);
		vh.sn.setText(shop.getSn());
		vh.name.setText(shop.getName());
		vh.price.setText(shop.getShop_price());
		
		return convertView;
	}

}
