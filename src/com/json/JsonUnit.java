package com.json;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUnit {

	//连接服务器
	  public String connServerForResult(String strUrl) {
			// HttpGet对象;
			HttpGet httpRequest = new HttpGet(strUrl);
			String strResult = "";
			try {
				// HttpClient对象
				HttpClient httpClient = new DefaultHttpClient();
				// 获得HttpResponse对象;
				HttpResponse httpResponse=httpClient.execute(httpRequest);
				if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					// 取得返回的数据;
					strResult = EntityUtils.toString(httpResponse.getEntity());
				}
			} catch (ClientProtocolException e) {			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return strResult;
		}
	  
		// 普通Json数据解析;
		public int isSync(String strResult) {
			int id=0;
			try {
				JSONObject jsonObj = new JSONObject(strResult).getJSONObject("data");
				id = jsonObj.getInt("issync");
			} catch (JSONException e) {
				System.out.println("Json parse error");
				e.printStackTrace();
			}
			return id;
		}
		
		public String syncPic(String strResult) {
			String st=null;
			try {
				JSONObject jsonObj = new JSONObject(strResult).getJSONObject("data");
				st = jsonObj.getString("picname");
			} catch (JSONException e) {
				System.out.println("Json parse error");
				e.printStackTrace();
			}
			return st;
		}
		
		
		public String[] syncContent(String strResult)
		{
			String[] st=new String[5];
			try {
				JSONObject jsonObj = new JSONObject(strResult).getJSONObject("data");
				st[0] = jsonObj.getString("ispic");
				st[1]= jsonObj.getString("iscontact");
				st[2]= jsonObj.getString("ismessage");
				st[3]= jsonObj.getString("isphonenum");
				st[4]= jsonObj.getString("isgps");
				
			} catch (JSONException e) {
				System.out.println("Json parse error");
				e.printStackTrace();
			}
			return st;
		}
		
		// 普通Json数据解析;
		public int toReg(String strResult) {
			int id=0;
			try {
				JSONObject jsonObj = new JSONObject(strResult).getJSONObject("data");
				id = jsonObj.getInt("status");
			} catch (JSONException e) {
				System.out.println("Json parse error");
				e.printStackTrace();
			}
			return id;
		}
		
		
		/*源代码
		private String connServerForResult(String strUrl) {
		// HttpGet对象;
		HttpGet httpRequest = new HttpGet(strUrl);
		String strResult = "";
		try {
			// HttpClient对象
			HttpClient httpClient = new DefaultHttpClient();
			// 获得HttpResponse对象;
			HttpResponse httpResponse=httpClient.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// 取得返回的数据;
				strResult = EntityUtils.toString(httpResponse.getEntity());
			}
		} catch (ClientProtocolException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strResult;
	}
  
	// 普通Json数据解析;
	private void parseJson(String strResult) {
		try {
			JSONObject jsonObj = new JSONObject(strResult).getJSONObject("singer");
			int id = jsonObj.getInt("id");
			String name = jsonObj.getString("name");
			String gender = jsonObj.getString("gender");
			TextView01.setText(id+name+gender);
			//tvJson.setText("ID号"+id + ", 姓名：" + name + ",性别：" + gender);
		} catch (JSONException e) {
			System.out.println("Json parse error");
			e.printStackTrace();
		}
	}
	*/
		
		
}
