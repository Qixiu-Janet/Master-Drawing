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
import org.achartengine.chart.PointStyle;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import com.test.AndroidChartApp.LineChartUI;
import com.test.bean.LineUseDataBean;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;

/**
 * Project status demo chart.
 */
public class LineChart extends AbstractChart {

	LineUseDataBean usedata = LineChartUI.usedata;// 用UseData的bean文件传输数据
	Intent intent;
	int HowInputNum = 4;// 定义每行的个数

	/**
	 * Returns the chart name.
	 * 
	 * @return the chart name
	 */
	public String getName() {
		return "Project tickets status";
	}

	/**
	 * Returns the chart description.
	 * 
	 * @return the chart description
	 */
	public String getDesc() {
		return "The opened tickets and the fixed tickets (time chart)";
	}

	/**
	 * Executes the chart demo.
	 * 
	 * @param context
	 *            the context
	 * @return the built intent
	 */
	public Intent execute(Context context) {

		// 图表下面的注释名字
		String[] titles = usedata.getDateName();
		List<double[]> values = new ArrayList<double[]>();
		List<double[]> x = new ArrayList<double[]>();
		// 线条的颜色取值范围
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

		// 获取输入值中最大组的子元素个数
		double[] listMaxNum = new double[getMaxNum(values)];
		for (int i = 0; i < getMaxNum(values); i++)
			listMaxNum[i] = i + 1;
		for (int i = 0; i < titles.length; i++) {
			// X轴，每点对应的位置，第1个是第一个位置，此数组个数决定了要输入元素的个数
			x.add(listMaxNum);
		}

		// 动态分配颜色
		int[] colors = new int[values.size()];
		for (int i = 0; i < values.size(); i++)
			colors[i] = colorsTemp[i];

		// 每个端点的形状,可自定义。如：PointStyle[] styles = new
		// PointStyle[]{PointStyle.POINT,PointStyle.CIRCLE};
		PointStyle[] styles = new PointStyle[values.size()];
		for (int i = 0; i < values.size(); i++)
			styles[i] = PointStyle.POINT;

		// 添加颜色和配色方案
		XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);

		setChartSettings(renderer, "折线图", "项目的个数", "项目值", 1, getValuesNum(tt),
				getMinValue(values), getMaxValue(values) + getMaxValue(values)
						* 0.15, Color.GRAY, Color.LTGRAY);

		renderer.setXLabels(getMaxNum(values)); // 设置具体的图形背景的竖线个数
		renderer.setYLabels(10); // 设置具体的图形背景的横线个数
		renderer.setShowGrid(true);
		return ChartFactory.getLineChartIntent(context, buildDataset(titles, x,
				values), renderer, "折线图");
	}

	/**
	 * 获取输入值中最大组的元素个数，以便确定表背景里的竖线个数(即:横轴精确度)
	 * 
	 * @param values
	 *            输入的值
	 * @return maxnum 最大组的个数
	 */
	public int getMaxNum(List<double[]> values) {
		int maxnum = values.get(0).length;
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i).length > maxnum)
				maxnum = values.get(i).length;
		}
		return maxnum;
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

	public double[][] isValues(double[][] num) {
		double[][] temp = null;
		int k = 0;
		for (int i = 0, w = 0; i < num.length; i++) {
			if (k == -1)
				break;
			for (int j = 0, c = 0; j < num.length; j++) {
				if (num[i][j] != -1) {
					temp[w][c] = num[i][j];
					c++;
				} else {
					k = -1;
					break;
				}
			}
			w++;
		}
		return temp;
	}

}
