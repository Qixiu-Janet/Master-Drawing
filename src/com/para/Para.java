package com.para;

//此类为所有用到的参数
public class Para {
	
	public String getIpaddr1()
	{
		return "192.168.1.102";
	}
	
	public int getPort1()
	{
		return 21;
	}
	
	public String getUsername1()
	{
		return "gg";
	}
	
	public String getPassword1()
	{
		return "123456";
	}
	
	public String getLocalDir1()
	{
		return "GetRestore";
	}
	
	public String getLocalFileName1()
	{
		return "synccontent.php";
	}
	
	//服务器里的文件夹在创建用户时创建，其它时候不可创建
	public String getServerDir1()
	{
		return "user01";
	}
	
	public String getServerFileName1()
	{
		return "synccontent.php";
	}

	//JSO获取http数据
	public String getSyncFileUrl1(String filename)
	{
		//return "http://"+getIpaddr()+":8887/"+filename;
		return null;
	}
	
	//更新时间间隔，毫秒为单位
	public int getInterval1()
	{
		return 1000;
	}
	
	

		
	

}
