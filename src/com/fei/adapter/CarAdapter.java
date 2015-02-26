package com.fei.adapter;

import java.util.List;

import com.example.winter_holiday.R;
import com.fei.bean.Car;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CarAdapter extends BaseAdapter{
	Context context;
	List<Car> list;
	
	public CarAdapter(Context context, List<Car> list) {
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
		TextView rec_id,user_id,session_id,goods_id,goods_sn,goods_name,market_price,goods_price,goods_number;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder vh=null;
		if(convertView==null){
			vh=new ViewHolder();
			convertView=LayoutInflater.from(context).inflate(R.layout.list_car, null);
			vh.rec_id=(TextView) convertView.findViewById(R.id.rec_id);
			vh.user_id=(TextView) convertView.findViewById(R.id.user_id);
			vh.session_id=(TextView) convertView.findViewById(R.id.session_id);
			vh.goods_id=(TextView) convertView.findViewById(R.id.goods_id);
			vh.goods_sn=(TextView) convertView.findViewById(R.id.goods_sn);
			vh.goods_name=(TextView) convertView.findViewById(R.id.goods_name);
			vh.market_price=(TextView) convertView.findViewById(R.id.market_price);
			vh.goods_price=(TextView) convertView.findViewById(R.id.goods_price);
			vh.goods_number=(TextView) convertView.findViewById(R.id.goods_number);
			convertView.setTag(vh);
			
		}else{
			vh=(ViewHolder) convertView.getTag();
		}
		
		Car c=list.get(position);
		vh.rec_id.setText("���ﳵ�е�ID��"+c.getRec_id());
		vh.user_id.setText("�û�ID��"+c.getUser_id());
		vh.session_id.setText("���������ID"+c.getSession_id());
		vh.goods_id.setText("��ƷID��"+c.getGoods_id());
		vh.goods_sn.setText("��Ʒ����"+c.getGoods_sn());
		vh.goods_name.setText("��Ʒ���ƣ�"+c.getGoods_name());
		vh.market_price.setText("�г��۸�"+c.getMarket_price());
		vh.goods_price.setText("����۸�"+c.getGoods_number());
		vh.goods_number.setText("��������"+c.getGoods_number());
		return convertView;
	}

}
