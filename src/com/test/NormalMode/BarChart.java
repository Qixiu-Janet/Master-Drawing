/**
 * Copyright (C) 2009, 2010 SC 4ViewSoft SRL
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.test.NormalMode;

import java.util.ArrayList;
import java.util.List;
import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import com.test.AndroidChartApp.BarChartUI;
import com.test.bean.LineUseDataBean;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;

/**
 * Sales demo bar chart.
 */
public class BarChart extends AbstractChart {

	LineUseDataBean usedata = BarChartUI.usedata;// ��UseData��bean�ļ���������
	Intent intent;
	int HowInputNum = 4;// ����ÿ�еĸ���

	/**
	 * Returns the chart name.
	 * 
	 * @return the chart name
	 */
	public String getName() {
		return "Sales stacked bar chart";
	}

	/**
	 * Returns the chart description.
	 * 
	 * @return the chart description
	 */
	public String getDesc() {
		return "The monthly sales for the last 2 years (stacked bar chart)";
	}

	/**
	 * Executes the chart demo.
	 * 
	 * @param context
	 *            the context
	 * @return the built intent
	 */
	public Intent execute(Context context) {
		String[] titles = usedata.getDateName();
		List<double[]> values = new ArrayList<double[]>();

		// ���ӵ���ɫȡֵ��Χ
		int[] colorsTemp = new int[] { Color.RED, Color.GREEN, Color.BLUE,
				Color.CYAN, Color.YELLOW, Color.MAGENTA, Color.LTGRAY,
				Color.WHITE, Color.DKGRAY, Color.rgb(208, 102, 21),
				Color.rgb(255, 208, 105) };

		// ��Ӿ����ֵ
		double[][] tt = usedata.getDateNum();
		for (int t = 0; t < tt.length; t++) {
			if (tt[t][0] == -1)
				break;
			values.add(tt[t]);
		}

//		for (int i = 0; i < tt.length; i++)
//			for (int j = 0; j < tt[0].length; j++)
//				Log.d("22222223", "2222222" + tt[i][j]);

		// ��̬������ɫ
		int[] colors = new int[values.size()];
		for (int i = 0; i < values.size(); i++)
			colors[i] = colorsTemp[i];

		XYMultipleSeriesRenderer renderer = buildBarRenderer(colors);
		setChartSettings(renderer, "��״ͼ", "��Ŀ�ĸ���", "��Ŀֵ", 0.5,
				getValuesNum(tt) + 0.5, 0, getMaxValue(values)
						+ getMaxValue(values) * 0.15, Color.GRAY, Color.LTGRAY);
		renderer.setXLabels(12);
		renderer.setYLabels(10);
		renderer.setDisplayChartValues(true);
		renderer.setShowGrid(true);
		return ChartFactory.getBarChartIntent(context, buildBarDataset(titles,
				values), renderer, Type.DEFAULT,"��״ͼ");
	}

	/**
	 * ��ȡ��������ֵ��������ֵ
	 * 
	 * @param values
	 * @return maxvalue���ֵ
	 */
	public double getMaxValue(List<double[]> values) {
		double maxvalue = values.get(0)[0];
		for (int i = 0; i < values.size(); i++) {
			for (int j = 0; j < values.get(i).length; j++) {
				if (values.get(i)[j] > maxvalue)
					maxvalue = values.get(i)[j];
			}
		}
		return maxvalue;
	}

	/**
	 * ��ȡ��������ֵ����С����ֵ
	 * 
	 * @param values
	 * @return minvalue��Сֵ
	 */
	public double getMinValue(List<double[]> values) {
		double minvalue = values.get(0)[0];
		for (int i = 0; i < values.size(); i++) {
			for (int j = 0; j < values.get(i).length; j++) {
				if (values.get(i)[j] < minvalue)
					minvalue = values.get(i)[j];
			}
		}
		return minvalue;
	}

	/**
	 * �жϴ����Ķ�ά�����У���Ч���֣���-1��������������ȡ���ȵģ��Ա��ȥ����Ľ���
	 * 
	 * @param num
	 * @return temp
	 */
	public int getValuesNum(double[][] num) {
		int temp = 0;

		for (int j = 0; j < num[0].length; j++) {
			if (num[0][j] != -1) {
				Log.d("11111", "11111" + num[0][j]);
				temp++;
			}
		}
		return temp;
	}

}
