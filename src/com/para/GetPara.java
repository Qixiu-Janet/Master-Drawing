package com.para;

import android.content.Context;
import android.content.SharedPreferences;

public class GetPara {

	//Ĭ�ϻ�ȡ�ַ���
	public String getPara(Context ctx,String attrib)
	{
	    //��ȡSharedPreferences����
	    SharedPreferences sp = ctx.getSharedPreferences("configurefile", Context.MODE_PRIVATE);   
	    //����STRING_KEY��ֵ,��������ڷ���0
	    return sp.getString(attrib, "0");
	}
	
	
	public int getParaInt(Context ctx,String attrib)
	{
	    //��ȡSharedPreferences����
	    SharedPreferences sp = ctx.getSharedPreferences("configurefile", Context.MODE_PRIVATE);   
	    //����STRING_KEY��ֵ,��������ڷ���0
	    return sp.getInt(attrib, 0);
	}
}
