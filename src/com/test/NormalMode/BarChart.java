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

	LineUseDataBean usedata = BarChartUI.usedata;// 用UseData的bean文件传输数据
	Intent intent;
	int HowInputNum = 4;// 定义每行的个数

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

		// 柱子的颜色取值范围
		int[] colorsTemp = new int[] { Color.RED, Color.GREEN, Color.BLUE,
				Color.CYAN, Color.YELLOW, Color.MAGENTA, Color.LTGRAY,
				Color.WHITE, Color.DKGRAY, Color.rgb(208, 102, 21),
				Color.rgb(255, 208, 105) };

		// 添加具体的值
		double[][] tt = usedata.getDateNum();
		for (int t = 0; t < tt.length; t++) {
			if (tt[t][0] == -1)
				break;
			values.add(tt[t]);
		}

//		for (int i = 0; i < tt.length; i++)
//			for (int j = 0; j < tt[0].length; j++)
//				Log.d("22222223", "2222222" + tt[i][j]);

		// 动态分配颜色
		int[] colors = new int[values.size()];
		for (int i = 0; i < values.size(); i++)
			colors[i] = colorsTemp[i];

		XYMultipleSeriesRenderer renderer = buildBarRenderer(colors);
		setChartSettings(renderer, "柱状图", "项目的个数", "项目值", 0.5,
				getValuesNum(tt) + 0.5, 0, getMaxValue(values)
						+ getMaxValue(values) * 0.15, Color.GRAY, Color.LTGRAY);
		renderer.setXLabels(12);
		renderer.setYLabels(10);
		renderer.setDisplayChartValues(true);
		renderer.setShowGrid(true);
		return ChartFactory.getBarChartIntent(context, buildBarDataset(titles,
				values), renderer, Type.DEFAULT,"柱状图");
	}

	/**
	 * 获取所有输入值中最大的数值
	 * 
	 * @param values
	 * @return maxvalue最大值
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
	 * 获取所有输入值中最小的数值
	 * 
	 * @param values
	 * @return minvalue最小值
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
	 * 判断传来的二维数组中，有效数字（非-1）个数，用来获取精度的，以便截去多余的界面
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
