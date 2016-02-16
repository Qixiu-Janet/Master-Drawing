package com.test.AndroidChartApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelpChart extends Activity {
	
	 private Button btn;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.help);
	        
	        btn=(Button)findViewById(R.id.helpbtn);
	        btn.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					HelpChart.this.finish();
				}	        	
	        });
	 }

}
