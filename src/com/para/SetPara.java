package com.para;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class SetPara {

	
	
	public void setPara(Context ctx,String attrib,String value)
	{
	    //获取SharedPreferences对象
	    SharedPreferences sp = ctx.getSharedPreferences("configurefile", Context.MODE_PRIVATE);
	
	    //存入数据
	    Editor editor = sp.edit();
	    editor.putString(attrib, value);
	    editor.commit();
	    
	    //返回STRING_KEY的值,如果不存在返回0
	    Log.d("SP", sp.getString("STRING_KEY", "0"));

	}
	
	public void setPara(Context ctx,String attrib,int value)
	{
	    //获取SharedPreferences对象
	    SharedPreferences sp = ctx.getSharedPreferences("configurefile", Context.MODE_PRIVATE);
	
	    //存入数据
	    Editor editor = sp.edit();
	    editor.putInt(attrib, value);
	    editor.commit();
	    
	}
	
	
    
}
