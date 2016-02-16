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

import org.achartengine.ChartFactory;
import org.achartengine.renderer.DefaultRenderer;
import com.test.AndroidChartApp.PieChartUI;
import com.test.bean.PieUseDataBean;
import android.content.Context;
import android.content.Intent;

/**
 * Budget demo pie chart.
 */
public class PieChart extends AbstractChart {

	PieUseDataBean usedata = PieChartUI.usedata;// 用UseData的bean文件传输数据
	Intent intent;

	/**
	 * Returns the chart name.
	 * 
	 * @return the chart name
	 */
	public String getName() {
		return "Budget chart";
	}

	/**
	 * Returns the chart description.
	 * 
	 * @return the chart description
	 */
	public String getDesc() {
		return "The budget per project for this year (pie chart)";
	}

	/**
	 * Executes the chart demo.
	 * 
	 * @param context
	 *            the context
	 * @return the built intent
	 */

	public Intent execute(Context context) {

		double[] values = usedata.getDateNum();
		int[] colors = usedata.getDataColor();
		String[] ProjectName = usedata.getDateName();
		DefaultRenderer renderer = buildCategoryRenderer(colors);
		renderer.setLabelsTextSize(10);
		return ChartFactory.getPieChartIntent(context, buildCategoryDataset(
				"饼图", values, ProjectName), renderer, "饼图");
	}

}
