package com.test.bean;

import android.graphics.Color;

public class LineUseDataBean {
	public String[] DateName;
	public double[][] DateNum;
	public int[] DataColor;
	// 下面的为图表的颜色取值（取色板）,我的取色范围是11个
	public int[] tt = new int[] { Color.RED, Color.GREEN, Color.BLUE,
			Color.MAGENTA, Color.YELLOW, Color.CYAN, Color.LTGRAY, Color.WHITE,
			Color.DKGRAY, Color.rgb(208, 102, 21), Color.rgb(255, 208, 105) };
	int i = 0;
	int j = 0;
	int k = 0;
	int temp = 0;

	public LineUseDataBean() {
	};

	/**
	 * 向DateName数组中添加值,并去除null值
	 * 
	 * @param StringName
	 *            每个项目的名字
	 */
	public void setDateName(String[] StringName) {

		for (int i = 0; i < StringName.length; i++) {
			if (StringName[i] != null)
				k++;
			else
				break;
		}

		DateName = new String[k];

		for (int i = 0; i < DateName.length; i++) {
			DateName[i] = StringName[i];
		}

	}

	/**
	 * 获取所有项目的名字
	 * 
	 * @return DateName 所有项目的名字
	 */
	public String[] getDateName() {

		return DateName;
	}

	/**
	 * 向DateNum数组中添加每个项目的值
	 * 
	 * @param DoubleNum
	 *            每个项目的值
	 */
	public void setDateNum(double[][] DoubleNum) {
		DateNum = DoubleNum;
	}

	/**
	 * 获取所有项目的值
	 * 
	 * @return DateNum 所有项目的值
	 */
	public double[][] getDateNum() {
		return DateNum;
	}

	/**
	 * 从已经定义的取色板里，获取图表的颜色
	 */
	public void setDateColor() {
		DataColor[k] = tt[k];
		k++;
	}

	public int[] getDataColor() {
		return DataColor;
	}

}
