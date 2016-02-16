package com.test.AndroidChartApp;

import com.json.JsonUnit;
import com.para.GetPara;
import com.para.SetPara;
import com.test.NormalMode.IChart;
import com.test.NormalMode.PieChart;
import com.test.bean.PieUseDataBean;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class PieChartUI extends Activity {
	public static PieUseDataBean usedata;
	public Intent intent = null;
	public int temp = 0;
	public final static String[] getTheName = new String[10];// ��ȡ��Ŀ���Ļ������
	public final static double[] getTheNum = new double[10];// ��ȡ��Ŀֵ�Ļ������

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.piechart);

		Button piechart_createButton = (Button) findViewById(R.id.piechart_createButton);
		Button piechart_addButton = (Button) findViewById(R.id.piechart_addButton);
		Button piechart_clearList = (Button) findViewById(R.id.piechart_clearList);
		final EditText inputName = (EditText) findViewById(R.id.inputName);
		final EditText inputNum = (EditText) findViewById(R.id.inputNum);
		final EditText fileName = (EditText) findViewById(R.id.fileName);

		// ���漸���������ڶ�̬���ɱ��
		final TableLayout table_list = (TableLayout) findViewById(R.id.table_list);
		final TableRow[] tableRow = new TableRow[10];
		final TextView[] viewText1 = new TextView[10];
		final TextView[] viewText2 = new TextView[10];

		for (int i = 0; i < viewText1.length; i++) {
			tableRow[i] = new TableRow(this);
			viewText1[i] = new TextView(this);
			viewText2[i] = new TextView(this);
			viewText2[i].setPadding(100, 0, 0, 0);// ���þ���ߵ���Ŀ���ֵľ���
		}

		piechart_addButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					// �Զ��������쳣���쳣���Ա�����������Ŀ�ĸ���
					int a[] = new int[2];
					if (temp > 7)
						a[1] = a[0] / 0;

					// �Զ����ָ���쳣���ǿ���֤
					int b[] = null;
					String ss = "";
					if (inputName.getText().toString().equals(ss)
							|| inputNum.getText().toString().equals(ss)) {
						a[0] = b.length;
					}

					String string = null;
					viewText1[temp].setText(inputName.getText());
					getTheName[temp] = inputName.getText().toString();
					viewText2[temp].setText(inputNum.getText());
					getTheNum[temp] = Double.parseDouble(inputNum.getText()
							.toString());
					tableRow[temp].addView(viewText1[temp]);
					tableRow[temp].addView(viewText2[temp]);

					
					//����ֵ������������
					JsonUnit ju=new JsonUnit();
					GetPara gp=new GetPara();
					SetPara sp=new SetPara();
					sp.setPara(v.getContext(), "filename", fileName.getText().toString());
					
					ju.connServerForResult("http://192.168.68.1:8887/charts/pie_submit.php?username="+gp.getPara(v.getContext(),"username")+"&filename="+gp.getPara(v.getContext(),"filename")+"&name="+inputName.getText()+"&value="+inputNum.getText());
					
	
					
					table_list.addView(tableRow[temp++]);
			
					
					// ��������
					inputName.setText(null);
					inputNum.setText(null);
				} catch (ArithmeticException e1) {
					showErrorAlert("		���������8����Ŀ");
				} catch (NullPointerException e2) {
					showErrorAlert("		��������Ŀ������Ŀֵ");
				} catch (Exception e) {

				}

			}
		});

		// �����б����ֵ������ͼ��
		piechart_createButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub

				try {
					// ����4��Ϊ������һ������Խ���쳣���Ա��ų��ǿյĴ���
					int[] a = new int[1];
					if (getTheNum[0] == 0.0 || getTheName[0] == null) {
						a[3]++;
					}

					int RealNum = getRealNum(getTheName, getTheNum);

					usedata = new PieUseDataBean(RealNum);

					for (int tt = 0; tt < RealNum; tt++) {
						usedata.setDateName(getTheName[tt]);
						usedata.setDateColor();
						usedata.setDateNum(getTheNum[tt]);
					}

					IChart[] mCharts = new IChart[] { new PieChart() };
					intent = mCharts[0].execute(PieChartUI.this);
					startActivity(intent);
				}

				catch (Exception e) {
					showErrorAlert("		��Ŀ�б�����ֵ,�����룡");
				}

				finally {
					// �����Ѻ���ʾ��
					Toast.makeText(getApplicationContext(), "����ͼ����...",
							Toast.LENGTH_SHORT).show();
					
					//����ֵ������������
					JsonUnit ju2=new JsonUnit();
					GetPara gp=new GetPara();
					SetPara sp=new SetPara();
					
					ju2.connServerForResult("http://192.168.68.1:8887/charts/pie.php?username="+gp.getPara(v.getContext(),"username")+"&filename="+gp.getPara(v.getContext(),"filename")+"thename="+theNum+"&thename="+theName);
					//Log.d("Hello","http://192.168.68.1:8887/charts/pie.php?username="+gp.getPara(v.getContext(),"username")+"&filename="+gp.getPara(v.getContext(),"filename"));
		
				}

			}

		});

		// ����б��������������ֵ
		piechart_clearList.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// !!!!!!!�ǿ��쳣�Ĵ�������������//
				for (int i = 0; i < 10; i++) {
					viewText1[i].setText(null);
					getTheName[i] = null;
					viewText2[i].setText(null);
					getTheNum[i] = 0;
					tableRow[i].removeAllViews();
					// table_list.removeAllViews();
				}
				inputName.setText(null);
				inputNum.setText(null);
				temp = 0;
			}
		});
	}

	/**
	 * ȷ�������з�null�ͷ�0���������(ֻ���ж�һά����)
	 * 
	 * @param string1
	 * @param int1
	 * @return
	 */
	public int getRealNum(String[] string1, double[] double1) {
		int tt = 0;
		for (int i = 0; i < string1.length; i++) {
			if (string1[i] == null || double1[i] == 0) {
				tt = i;
				break;
			}
		}
		return tt;
	}

	// ��ʼ�������
	private void showErrorAlert(CharSequence message) {
		new AlertDialog.Builder(PieChartUI.this).setTitle("			����").setMessage(
				message).setPositiveButton("ȷ��",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
					}
				}).setCancelable(false).show();
	}

}