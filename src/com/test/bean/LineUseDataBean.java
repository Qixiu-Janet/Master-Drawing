package com.test.bean;

import android.graphics.Color;

public class LineUseDataBean {
	public String[] DateName;
	public double[][] DateNum;
	public int[] DataColor;
	// �����Ϊͼ�����ɫȡֵ��ȡɫ�壩,�ҵ�ȡɫ��Χ��11��
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
	 * ��DateName���������ֵ,��ȥ��nullֵ
	 * 
	 * @param StringName
	 *            ÿ����Ŀ������
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
	 * ��ȡ������Ŀ������
	 * 
	 * @return DateName ������Ŀ������
	 */
	public String[] getDateName() {

		return DateName;
	}

	/**
	 * ��DateNum���������ÿ����Ŀ��ֵ
	 * 
	 * @param DoubleNum
	 *            ÿ����Ŀ��ֵ
	 */
	public void setDateNum(double[][] DoubleNum) {
		DateNum = DoubleNum;
	}

	/**
	 * ��ȡ������Ŀ��ֵ
	 * 
	 * @return DateNum ������Ŀ��ֵ
	 */
	public double[][] getDateNum() {
		return DateNum;
	}

	/**
	 * ���Ѿ������ȡɫ�����ȡͼ�����ɫ
	 */
	public void setDateColor() {
		DataColor[k] = tt[k];
		k++;
	}

	public int[] getDataColor() {
		return DataColor;
	}

}
