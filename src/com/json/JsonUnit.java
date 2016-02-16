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

	//���ӷ�����
	  public String connServerForResult(String strUrl) {
			// HttpGet����;
			HttpGet httpRequest = new HttpGet(strUrl);
			String strResult = "";
			try {
				// HttpClient����
				HttpClient httpClient = new DefaultHttpClient();
				// ���HttpResponse����;
				HttpResponse httpResponse=httpClient.execute(httpRequest);
				if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					// ȡ�÷��ص�����;
					strResult = EntityUtils.toString(httpResponse.getEntity());
				}
			} catch (ClientProtocolException e) {			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return strResult;
		}
	  
		// ��ͨJson���ݽ���;
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
		
		// ��ͨJson���ݽ���;
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
		
		
		/*Դ����
		private String connServerForResult(String strUrl) {
		// HttpGet����;
		HttpGet httpRequest = new HttpGet(strUrl);
		String strResult = "";
		try {
			// HttpClient����
			HttpClient httpClient = new DefaultHttpClient();
			// ���HttpResponse����;
			HttpResponse httpResponse=httpClient.execute(httpRequest);
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// ȡ�÷��ص�����;
				strResult = EntityUtils.toString(httpResponse.getEntity());
			}
		} catch (ClientProtocolException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strResult;
	}
  
	// ��ͨJson���ݽ���;
	private void parseJson(String strResult) {
		try {
			JSONObject jsonObj = new JSONObject(strResult).getJSONObject("singer");
			int id = jsonObj.getInt("id");
			String name = jsonObj.getString("name");
			String gender = jsonObj.getString("gender");
			TextView01.setText(id+name+gender);
			//tvJson.setText("ID��"+id + ", ������" + name + ",�Ա�" + gender);
		} catch (JSONException e) {
			System.out.println("Json parse error");
			e.printStackTrace();
		}
	}
	*/
		
		
}
