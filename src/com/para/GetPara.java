package com.para;

import android.content.Context;
import android.content.SharedPreferences;

public class GetPara {

	//默认获取字符型
	public String getPara(Context ctx,String attrib)
	{
	    //获取SharedPreferences对象
	    SharedPreferences sp = ctx.getSharedPreferences("configurefile", Context.MODE_PRIVATE);   
	    //返回STRING_KEY的值,如果不存在返回0
	    return sp.getString(attrib, "0");
	}
	
	
	public int getParaInt(Context ctx,String attrib)
	{
	    //获取SharedPreferences对象
	    SharedPreferences sp = ctx.getSharedPreferences("configurefile", Context.MODE_PRIVATE);   
	    //返回STRING_KEY的值,如果不存在返回0
	    return sp.getInt(attrib, 0);
	}
}
