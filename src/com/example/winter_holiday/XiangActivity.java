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

import com.fei.adapter.HomeAdapter;
import com.fei.adapter.XiangAdapter;
import com.fei.bean.Shop;
import com.fei.bean.Xiang;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class XiangActivity extends Activity {
	ListView lv;
	Button back;
	String path="http://www.yasite.net/shopapi/index.php/goodController/getCategory/1";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xiang);
		lv=(ListView) findViewById(R.id.lv);
		back=(Button) findViewById(R.id.back);
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(XiangActivity.this,InterActivity.class);
				startActivity(intent);
			}
		});
		
		new Thread(new MainThread()).start();
		
	}

	public List<Xiang> parse(String path){
		List<Xiang> list=new ArrayList<Xiang>();
		try {
			JSONObject obj=new JSONObject(path);
			JSONArray arr=obj.getJSONArray("data");
			for(int i=0;i<arr.length();i++){
				JSONObject json=arr.getJSONObject(i);
				String id=json.getString("cat_id");
				String name=json.getString("cat_name");
				String parent_id=json.getString("parent_id");
				String order=json.getString("sort_order");
				
				Xiang xiang=new Xiang(id, name, parent_id, order);
				list.add(xiang);
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
					List<Xiang> list=parse(json);
					
					XiangAdapter adapter=new XiangAdapter(XiangActivity.this, list);
					lv.setAdapter(adapter);
					
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


}
