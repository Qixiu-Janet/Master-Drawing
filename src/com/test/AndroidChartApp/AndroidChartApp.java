package com.test.AndroidChartApp;

import com.test.paint.FingerPaint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/////////////////主页面！！！！！！！！！！！！！！！！！

public class AndroidChartApp extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simpleui);
        
        Button login_button1=(Button)findViewById(R.id.simpleui_button1);
        Button login_button2=(Button)findViewById(R.id.simpleui_button2);
        Button login_button3=(Button)findViewById(R.id.simpleui_button3);
        Button login_button4=(Button)findViewById(R.id.simpleui_button4);
        Button login_button5=(Button)findViewById(R.id.simpleui_button5);
        Button login_button6=(Button)findViewById(R.id.simpleui_button6);
        
        login_button1.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v) { 		
        	// TODO Auto-generated method stub
        		Intent showNextPage_Intent=new Intent();
        		showNextPage_Intent.setClass(AndroidChartApp.this,PieChartUI.class);
        		startActivity(showNextPage_Intent);
        		
        		overridePendingTransition(R.anim.fade, R.anim.hold);//换页特效
        		
        	}
        	});
        
        login_button2.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v) { 		
        	// TODO Auto-generated method stub
        		Intent showNextPage_Intent=new Intent();
        		showNextPage_Intent.setClass(AndroidChartApp.this,LineChartUI.class);
        		startActivity(showNextPage_Intent);
        		overridePendingTransition(R.anim.fade, R.anim.hold);//换页特效
        	}
        	});
        
      
        login_button3.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v) { 		
        	// TODO Auto-generated method stub
        		Intent showNextPage_Intent=new Intent();
        		showNextPage_Intent.setClass(AndroidChartApp.this,BarChartUI.class);
        		startActivity(showNextPage_Intent);
        		overridePendingTransition(R.anim.fade, R.anim.hold);//换页特效
        	}
        	});
        
        login_button4.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v) { 		
        	// TODO Auto-generated method stub
        		Intent showNextPage_Intent=new Intent();
        		showNextPage_Intent.setClass(AndroidChartApp.this,FingerPaint.class);
        		startActivity(showNextPage_Intent);
        		overridePendingTransition(R.anim.fade, R.anim.hold);//换页特效
        	}
        	});
        
        login_button5.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v) { 		
        	// TODO Auto-generated method stub
        		Intent showNextPage_Intent=new Intent();
        		showNextPage_Intent.setClass(AndroidChartApp.this,HelpChart.class);
        		startActivity(showNextPage_Intent);
        		overridePendingTransition(R.anim.fade, R.anim.hold);//换页特效
        	}
        	});
        
        login_button6.setOnClickListener(new OnClickListener(){
        	@Override
        	public void onClick(View v) { 		
        	// TODO Auto-generated method stub
        		AndroidChartApp.this.finish();
        	}
        	});
   

    }
}
