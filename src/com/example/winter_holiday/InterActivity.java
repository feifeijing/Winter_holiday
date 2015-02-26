package com.example.winter_holiday;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fei.adapter.CarAdapter;
import com.fei.adapter.ClassfyAdapter;
import com.fei.adapter.HomeAdapter;
import com.fei.adapter.MeAdapter;
import com.fei.bean.Car;
import com.fei.bean.Classfy;
import com.fei.bean.Shop;
import com.fei.bean.User;
import com.fei.dao.ClassfyData;
import com.fei.dao.UserDao;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class InterActivity extends TabActivity{
	ListView lv1,lv2,lv3,lv4;
	Button button;
	String path="http://www.yasite.net/shopapi/index.php/goodController/getGoodList/1";
	String path1="http://www.yasite.net/shopapi/index.php/cartController/addGood/1";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inter);
		lv1=(ListView) findViewById(R.id.lv1);
		lv2=(ListView) findViewById(R.id.lv2);
		lv3=(ListView) findViewById(R.id.lv3);
		lv4=(ListView) findViewById(R.id.lv4);
		
		button=(Button) findViewById(R.id.data);
		
		TabHost tabHost=getTabHost();
		TabSpec spec1=tabHost.newTabSpec("spec1");
		spec1.setIndicator("首页");
		spec1.setContent(R.id.tab1);
		tabHost.addTab(spec1);
		
		TabSpec spec2=tabHost.newTabSpec("spec2");
		spec2.setIndicator("分类");
		spec2.setContent(R.id.tab2);
		tabHost.addTab(spec2);
		
		TabSpec spec3=tabHost.newTabSpec("spec3");
		spec3.setIndicator("购物车");
		spec3.setContent(R.id.tab3);
		tabHost.addTab(spec3);
		
		TabSpec spec4=tabHost.newTabSpec("spec4");
		spec4.setIndicator("我");
		spec4.setContent(R.id.tab4);
		tabHost.addTab(spec4);
		tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				if(tabId.equals("spec1")){
					new Thread(new MainThread()).start();
				}
				if(tabId.equals("spec2")){
					List<Classfy> list=new ClassfyData().getdata();
					ClassfyAdapter adapter=new ClassfyAdapter(InterActivity.this, list);
					lv2.setAdapter(adapter);
					lv2.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> parent,
								View view, int position, long id) {
							// TODO Auto-generated method stub
							Intent intent=new Intent(InterActivity.this,XiangActivity.class);
							startActivity(intent);
						}
						
					});
				}
				
				if(tabId.equals("spec3")){
					new Thread(new shopping()).start();
				}
				
				if(tabId.equals("spec4")){
					View view=getLayoutInflater().inflate(R.layout.header, null);
					
					List<User> list=new UserDao().getdata();
					MeAdapter adapter=new MeAdapter(InterActivity.this, list);
					lv4.addHeaderView(view);
					lv4.setAdapter(adapter);
				}
				
			}
		});
		
		
	}
	public List<Shop> parse(String path){
		List<Shop> list=new ArrayList<Shop>();
		try {
			JSONObject obj=new JSONObject(path);
			JSONArray arr=obj.getJSONArray("data");
			for(int i=0;i<arr.length();i++){
				JSONObject json=arr.getJSONObject(i);
				String id=json.getString("goods_id");
				String sn=json.getString("goods_sn");
				String name=json.getString("goods_name");
				String thumb=json.getString("goods_thumb");
				String img=json.getString("goods_img");
				String market_price=json.getString("market_price");
				String shop_price=json.getString("shop_price");
				
				Shop shop=new Shop(id, sn, name, thumb, img, market_price, shop_price);
				list.add(shop);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public class MainThread implements Runnable{
			Handler handler=new Handler(){
				public void handleMessage(Message msg) {
					String json=(String) msg.obj;
					List<Shop> list=parse(json);
					final HomeAdapter adapter=new HomeAdapter(InterActivity.this, list);
					
					lv1.setAdapter(adapter);
					lv1.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> parent,
								View view, int position, long id) {
							// TODO Auto-generated method stub
							Intent intent=new Intent(InterActivity.this,ShopActivity.class);
							Shop shop=(Shop) adapter.getItem(position);
							intent.putExtra("shop", shop);
							startActivity(intent);
							
						}
					});
				};
			};
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					
					HttpClient client=new DefaultHttpClient();
					HttpPost post=new HttpPost(path);
					HttpConnectionParams.setConnectionTimeout(client.getParams(),3000);
					HttpConnectionParams.setSoTimeout(client.getParams(), 3000);
					System.out.println("开始网络请求");
					HttpResponse response=client.execute(post);
					System.out.println("进行到response");
					int code=response.getStatusLine().getStatusCode();
					if(code==200){
						System.out.println("可以开始请求");
						InputStream is=response.getEntity().getContent();
						byte[] b=new byte[4*1024];
						int length=0;
						StringBuffer sb=new StringBuffer();
						while((length=is.read(b))!=-1){
							sb.append(new String(b,0,length));
						}
						
						System.out.println("请求到的json文件="+sb.toString());
						
						Message msg=handler.obtainMessage();
						msg.obj=sb.toString();
						
						handler.sendMessage(msg);
					}else{
						System.out.println("状态码错误!");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	public List<Car> getshop(String path){
		List<Car> list=new ArrayList<Car>();
		try {
			JSONObject obj=new JSONObject(path);
			JSONObject json=obj.getJSONObject("data");
				
				String rec_id=json.getString("rec_id");
				String user_id=json.getString("user_id");
				String session_id=json.getString("session_id");
				String goods_id=json.getString("goods_id");
				String goods_sn=json.getString("goods_sn");
				String goods_name=json.getString("goods_name");
				String market_price=json.getString("market_price");
				String goods_price=json.getString("goods_price");
				String goods_number=json.getString("goods_number");
				Car car=new Car(rec_id, user_id, session_id, goods_id, goods_sn, goods_name, market_price, goods_price, goods_number);
				
				list.add(car);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public class shopping implements Runnable{
			Handler handler=new Handler(){
				public void handleMessage(Message msg) {
					String json=(String) msg.obj;
					List<Car> list=getshop(json);
					CarAdapter car=new CarAdapter(InterActivity.this, list);
					
					lv3.setAdapter(car);
					
				};
			};
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					
					HttpClient client=new DefaultHttpClient();
					HttpPost post=new HttpPost(path1);
					HttpConnectionParams.setConnectionTimeout(client.getParams(),3000);
					HttpConnectionParams.setSoTimeout(client.getParams(), 3000);
					System.out.println("开始网络请求");
					HttpResponse response=client.execute(post);
					System.out.println("进行到response");
					int code=response.getStatusLine().getStatusCode();
					if(code==200){
						System.out.println("可以开始请求");
						InputStream is=response.getEntity().getContent();
						byte[] b=new byte[4*1024];
						int length=0;
						StringBuffer sb=new StringBuffer();
						while((length=is.read(b))!=-1){
							sb.append(new String(b,0,length));
						}
						
						System.out.println("请求到的json文件="+sb.toString());
						
						Message msg=handler.obtainMessage();
						msg.obj=sb.toString();
						
						handler.sendMessage(msg);
					}else{
						System.out.println("状态码错误!");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

}
