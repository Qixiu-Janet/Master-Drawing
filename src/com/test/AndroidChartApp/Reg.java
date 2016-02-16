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
				Toast.makeText(getApplicationContext(), "�û��������벻��Ϊ��",Toast.LENGTH_SHORT).show();
			else
			{
				if(!et_regpassword.getText().toString().equals(et_regpassword2.getText().toString()))
					Toast.makeText(getApplicationContext(), "�������벻һ��",Toast.LENGTH_SHORT).show();
				else
				{
		
						//thestatus��0Ϊע���û����ڣ�1Ϊע��ɹ�
						int thestatus;
						//��regphone��php�����û��������룬������֤�������û�Ϊ0��������Ϊ1
						strResult = ju.connServerForResult("http://192.168.68.1:8887/charts/regphone.php?username="+et_regusername.getText().toString()+"&password="+et_regpassword.getText().toString());
						thestatus=ju.toReg(strResult);	//����������ֵ��0��1
						
						//0�û����ڣ�����ע��
						if(thestatus==0)
							Toast.makeText(getApplicationContext(), "�û�������",Toast.LENGTH_SHORT).show();
						else
						{
							//���ע��ɹ���д�뵽���ֻ��Ŀ���
							sp.setPara(v.getContext(), "username", et_regusername.getText().toString());
							sp.setPara(v.getContext(), "password", et_regpassword.getText().toString());
							

							Toast.makeText(getApplicationContext(), "��ϲ,ע��ɹ�",Toast.LENGTH_SHORT).show();
							
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
