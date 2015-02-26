package com.example.winter_holiday;

import com.fei.bean.Shop;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShopActivity extends Activity {
	TextView id,name,sn,goods_price,shop_price;
	Button buy,shopping;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop);
		buy=(Button) findViewById(R.id.buy);
		shopping=(Button) findViewById(R.id.shopping);
		
		id=(TextView) findViewById(R.id.id);
		name=(TextView) findViewById(R.id.name);
		sn=(TextView) findViewById(R.id.sn);
		goods_price=(TextView) findViewById(R.id.market_price);
		shop_price=(TextView) findViewById(R.id.shop_price);
		
		Intent intent=getIntent();
		Shop shop=(Shop) intent.getSerializableExtra("shop");
		id.setText("商品ID号："+shop.getId());
		name.setText("商品名称："+shop.getName());
		sn.setText("商品编号："+shop.getSn());
		goods_price.setText("市场价格："+shop.getMarket_price());
		shop_price.setText("本商店价格："+shop.getShop_price());
		
		shopping.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(ShopActivity.this, "恭喜您，商品已添加到购物车", 0).show();
			}
		});
	}

	

}
