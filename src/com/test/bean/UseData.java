package com.test.bean;

import android.graphics.Color;

public class UseData {
	public String[] DateName;
	public double[] DateNum;
	public int[] DataColor;
	// �����Ϊͼ�����ɫȡֵ��ȡɫ�壩,�ҵ�ȡɫ��Χ��11��
	public int[] tt = new int[] { Color.RED, Color.GREEN, Color.BLUE,
			Color.CYAN, Color.YELLOW, Color.MAGENTA, Color.LTGRAY, Color.WHITE,
			Color.DKGRAY, Color.rgb(208, 102, 21), Color.rgb(255, 208, 105) };
	int i = 0;
	int j = 0;
	int k = 0;
	int temp = 0;

	// Ϊ��ʹDateName��DateNum�������ݵĴ�С��Ϊ����,ʹ����Ĵ�С���̶�
	public UseData(int k) {
		// TODO Auto-generated constructor stub
		DateName = new String[k];
		DateNum = new double[k];
		DataColor = new int[k];
	}

	public UseData() {
	};

	/**
	 * ��DateName���������ֵ
	 * 
	 * @param StringName
	 *            ÿ����Ŀ������
	 */
	public void setDateName(String StringName) {
		DateName[i] = StringName;
		i++;
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
	public void setDateNum(double DoubleNum) {
		DateNum[j] = DoubleNum;
		j++;
	}

	/**
	 * ��ȡ������Ŀ��ֵ
	 * 
	 * @return DateNum ������Ŀ��ֵ
	 */
	public double[] getDateNum() {
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
