package com.para;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class SetPara {

	
	
	public void setPara(Context ctx,String attrib,String value)
	{
	    //��ȡSharedPreferences����
	    SharedPreferences sp = ctx.getSharedPreferences("configurefile", Context.MODE_PRIVATE);
	
	    //��������
	    Editor editor = sp.edit();
	    editor.putString(attrib, value);
	    editor.commit();
	    
	    //����STRING_KEY��ֵ,��������ڷ���0
	    Log.d("SP", sp.getString("STRING_KEY", "0"));

	}
	
	public void setPara(Context ctx,String attrib,int value)
	{
	    //��ȡSharedPreferences����
	    SharedPreferences sp = ctx.getSharedPreferences("configurefile", Context.MODE_PRIVATE);
	
	    //��������
	    Editor editor = sp.edit();
	    editor.putInt(attrib, value);
	    editor.commit();
	    
	}
	
	
    
}
