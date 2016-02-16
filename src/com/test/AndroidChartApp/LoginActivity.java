package com.test.AndroidChartApp;

import java.io.File;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.json.JsonUnit;
import com.para.DefaultPara;
import com.para.GetPara;
import com.para.SetPara;

public class LoginActivity extends Activity
{
	public EditText et_username,et_password;
	public Button bt_commit;
	public TextView tv_passlogin,tv_reg;
	
	JsonUnit ju=new JsonUnit();
	String strResult=null;
	
	GetPara gp=new GetPara();
	SetPara sp=new SetPara();
	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState)
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.loginface);
	    
	    et_username=(EditText)findViewById(R.id.et_username);
	    et_password=(EditText)findViewById(R.id.et_password);
	    bt_commit=(Button)findViewById(R.id.bt_commit);
	    tv_passlogin=(TextView)findViewById(R.id.tv_passlogin);
	    tv_reg=(TextView)findViewById(R.id.tv_reg);
	    bt_commit.setOnClickListener(new loginAction());
	    tv_passlogin.setOnClickListener(new loginAction2());
	    tv_reg.setOnClickListener(new loginAction3());
	  }
	  
	  class loginAction implements OnClickListener
	  {
		@Override
		public void onClick(View v) {
			
			int thestatus;
			strResult = ju.connServerForResult("http://192.168.68.1:8887/charts/logincheckphone.php?username="+et_username.getText().toString()+"&password="+et_password.getText().toString());
			
			thestatus=ju.toReg(strResult);
			
			if(thestatus==1)
			{
			createPath(Environment.getExternalStorageDirectory()+"/."+et_username.getText().toString());//创建配置文件夹
			DefaultPara dp=new DefaultPara();
			dp.exec(v.getContext());
			sp.setPara(v.getContext(), "username", et_username.getText().toString());
	        Intent showNextPage_Intent=new Intent();                
	        showNextPage_Intent.setClass(LoginActivity.this,AndroidChartApp.class);                
	        startActivity(showNextPage_Intent);
			}
		}
		  
	  }
	  
	  
	  
	  class loginAction2 implements OnClickListener
	  {
		@Override
		public void onClick(View v) {

			Intent showNextPage_Intent=new Intent();                
	        showNextPage_Intent.setClass(LoginActivity.this,AndroidChartApp.class);                
	        startActivity(showNextPage_Intent);
			
		}
	  }

	  class loginAction3 implements OnClickListener
	  {
		@Override
		public void onClick(View v) {

			Intent showNextPage_Intent=new Intent();                
	        showNextPage_Intent.setClass(LoginActivity.this,Reg.class);                
	        startActivity(showNextPage_Intent);
			
		}
	  }
	  
		/*
		 * 创建配置文件存储路径
		 */
		 public void createPath(String path) {
		     File file = new File(path);
		     if (!file.exists()) {
		         file.mkdirs();
		     }
		 }
}
