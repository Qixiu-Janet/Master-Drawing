package com.test.AndroidChartApp;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.json.JsonUnit;
import com.para.DefaultPara;
import com.para.GetPara;
import com.para.SetPara;



public class Reg extends Activity
{
	public Button bt_reg;
	public TextView tv_login;
	public EditText et_regpassword,et_regpassword2,et_regusername;
	public LinearLayout ll_reg;
	
	GetPara gp=new GetPara();
	SetPara sp=new SetPara();
	
	JsonUnit ju=new JsonUnit();
	String strResult=null;
	
	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState)
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.reg);

	    
	    //Log.d("hellott","1");
	    
	    bt_reg=(Button)findViewById(R.id.bt_reg);
	    et_regpassword=(EditText)findViewById(R.id.et_regpassword);
	    et_regpassword2=(EditText)findViewById(R.id.et_regpassword2);
	    et_regusername=(EditText)findViewById(R.id.et_regusername);

	    bt_reg.setOnClickListener(new regAction());

	  }		  
	  
	  class regAction implements OnClickListener
	  {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			new DefaultPara().setAddr(v.getContext());
			
			if(et_regusername.getText().toString().equals("")||et_regpassword.getText().toString().equals("")||et_regpassword2.getText().toString().equals(""))
				Toast.makeText(getApplicationContext(), "用户名和密码不能为空",Toast.LENGTH_SHORT).show();
			else
			{
				if(!et_regpassword.getText().toString().equals(et_regpassword2.getText().toString()))
					Toast.makeText(getApplicationContext(), "两次密码不一致",Toast.LENGTH_SHORT).show();
				else
				{
		
						//thestatus中0为注册用户存在，1为注册成功
						int thestatus;
						//向regphone。php传入用户名和密码，进行验证。存在用户为0，不存在为1
						strResult = ju.connServerForResult("http://192.168.68.1:8887/charts/regphone.php?username="+et_regusername.getText().toString()+"&password="+et_regpassword.getText().toString());
						thestatus=ju.toReg(strResult);	//解析传来的值是0或1
						
						//0用户存在，不能注册
						if(thestatus==0)
							Toast.makeText(getApplicationContext(), "用户名存在",Toast.LENGTH_SHORT).show();
						else
						{
							//如果注册成功，写入到本手机的库里
							sp.setPara(v.getContext(), "username", et_regusername.getText().toString());
							sp.setPara(v.getContext(), "password", et_regpassword.getText().toString());
							

							Toast.makeText(getApplicationContext(), "恭喜,注册成功",Toast.LENGTH_SHORT).show();
							
					        final Intent showNextPage_Intent=new Intent();                
					        showNextPage_Intent.setClass(Reg.this,AndroidChartApp.class);   
							
							Timer timer=new Timer();
							TimerTask tast=new TimerTask()
							  {
							   @Override
							   public void run(){
							    startActivity(showNextPage_Intent);
							   }
							  };
							  timer.schedule(tast,2000);
							  
						}

					}
			}
		}
	  }

	  

	  
}
