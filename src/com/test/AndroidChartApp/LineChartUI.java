package com.test.AndroidChartApp;

import com.json.JsonUnit;
import com.para.GetPara;
import com.para.SetPara;
import com.test.NormalMode.IChart;
import com.test.NormalMode.LineChart;
import com.test.bean.LineUseDataBean;
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

public class LineChartUI extends Activity {

	public static LineUseDataBean usedata;
	public Intent intent = null;
	public final static String[] getTheName = new String[10];// ��ȡ��Ŀ���Ļ������
	public final static double[][] getTheNum = new double[12][12];// �ö�ά�����ȡ��Ŀֵ�Ļ������
	public int temp = 0;// getTheNum[temp][temp2]
	public int temp2 = 0; // ���������ܸ������Ӧ
	public int HowInputNum = 0; // ��ȡ��������������ָ���
	public int inputnum_editText1_temp = 0; // inputnum_editText1�Ļ������

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linechart);

		Button linechart_createButton = (Button) findViewById(R.id.linechart_createButton);
		Button linechart_addButton = (Button) findViewById(R.id.linechart_addButton);
		Button linechart_clearList = (Button) findViewById(R.id.linechart_clearList);
		final EditText linechart_inputName = (EditText) findViewById(R.id.linechart_inputName);
		final EditText linechart_fileName = (EditText) findViewById(R.id.linechart_fileName);

		HowInputNum = 8;
		// ���漸���������ڶ�̬�����������ݱ��
		final TableLayout linechart_table_list = (TableLayout) findViewById(R.id.linechart_table_list);
		final TableRow[] tableRow = new TableRow[10];
		final TextView[] viewText1 = new TextView[10];
		final TextView[] viewText2 = new TextView[10];

		// ��̬���������
		final TableLayout inputnum_list = (TableLayout) findViewById(R.id.inputnum_list);
		final TableRow[] inputnumRow = new TableRow[12];
		final EditText[] inputnum_editText1 = new EditText[12];
		final TextView[] inputnum_textView2 = new TextView[3]; // ÿ�е���ʾ1��>4

		// ��ʼ��getTheNum��ά����
		for (int i = 0; i < getTheNum.length; i++)
			for (int j = 0; j < getTheNum[0].length; j++)
				getTheNum[i][j] = -1;

		// ��ʼ����̬���ݽ��
		for (int i = 0; i < viewText1.length; i++) {
			tableRow[i] = new TableRow(this);
			viewText1[i] = new TextView(this);
			viewText2[i] = new TextView(this);
			viewText2[i].setPadding(100, 0, 0, 0);// ���þ���ߵ���Ŀ���ֵľ���
		}

		// ��ʼ�������
		inputnum_list.setPadding(1, 1, 1, 1);
		for (int i = 0; i < inputnum_editText1.length; i++) {
			inputnumRow[i] = new TableRow(this);
			inputnum_editText1[i] = new EditText(this);
			inputnum_editText1[i].setWidth(58);
			if (i < 3) {
				inputnum_textView2[i] = new TextView(this);
			}
		}
		inputnum_textView2[0].setText("��д˳��1��4");
		inputnum_textView2[1].setText("��д˳��5��8");
		inputnum_textView2[2].setText("��д˳��9��12");

		// �����������Զ���
		int kk = 0;
		for (int i = 0; i < HowInputNum; i++) {
			if (i % 4 == 0) // �ж�ÿ�и���
			{
				kk++;
				inputnum_list.addView(inputnumRow[kk]);
				inputnumRow[kk].addView(inputnum_textView2[kk - 1]);
			}
			inputnumRow[kk].addView(inputnum_editText1[i]);
		}

		linechart_addButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// !!!!!!!�ǿ��쳣�Ĵ�������������//
				try {
					// �Զ��������쳣���쳣���Ա�����������Ŀ�ĸ���
					int a[] = new int[2];
					if (temp > 5)
						a[1] = a[0] / 0;

					// �Զ����ָ���쳣���ǿ���֤
					int b[] = null;
					String ss = "";
					if (linechart_inputName.getText().toString().equals(ss)
							|| inputnum_editText1[0].getText().toString()
									.equals(ss)) {
						a[0] = b.length;
					}

					viewText1[temp].setText(linechart_inputName.getText());
					getTheName[temp] = linechart_inputName.getText().toString();

					inputnum_editText1_temp = 0;
					String string = "";
					for (int j = 0; j < 12; j++) {
						if (inputnum_editText1[inputnum_editText1_temp]
								.getText().toString().equals(string)) {
							getTheNum[temp][j] = -1;
						} else {
							getTheNum[temp][j] = Double
									.parseDouble(inputnum_editText1[inputnum_editText1_temp]
											.getText().toString());
						}
						inputnum_editText1_temp++;
					}

					viewText2[temp].setText("" + howMany(getTheNum, temp)
							+ "��Ԫ��");
					tableRow[temp].addView(viewText1[temp]);
					tableRow[temp].addView(viewText2[temp]);

					
					//����ֵ������������
					JsonUnit ju=new JsonUnit();
					GetPara gp=new GetPara();
					SetPara sp=new SetPara();
					int dd[]=new int[12];
					for(int i=0;i<dd.length;i++)
						dd[i]=0;

					for(int i=0;i<getTheNum[temp].length;i++)
					{
						if(getTheNum[temp][i]!=-1)
							dd[i]=(int)getTheNum[temp][i];
						else
							dd[i]=0;
					}
					
					String value_all="";
					
					for(int i=0;i<8;i++)
						if(i==0)
							value_all="value"+(i+1)+"="+dd[i];
						else
							value_all=value_all+"&value"+(i+1)+"="+dd[i];
							
					sp.setPara(v.getContext(), "filename", linechart_fileName.getText().toString());
					ju.connServerForResult("http://192.168.68.1:8887/charts/line_submit.php?username="+gp.getPara(v.getContext(),"username")+"&filename="+gp.getPara(v.getContext(),"filename")+"&name="+linechart_fileName.getText()+"&"+value_all);

					
					Log.d("Hello","http://192.168.68.1:8887/charts/line_submit.php?username="+gp.getPara(v.getContext(),"username")+"&filename="+gp.getPara(v.getContext(),"filename")+"&name="+linechart_fileName.getText()+"&"+value_all);
					
									
					linechart_table_list.addView(tableRow[temp++]);

					// ��������
					linechart_inputName.setText(null);
					for (int i = 0; i < inputnum_editText1.length; i++) {
						inputnum_editText1[i].setText(null);
					}

				}

				catch (ArithmeticException e1) {
					showErrorAlert("		���������6����Ŀ");
				} catch (NullPointerException e2) {
					showErrorAlert("		��������Ŀ������Ŀֵ");
				} catch (Exception e) {

				}
			}
		});

		// �����б����ֵ������ͼ��
		linechart_createButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// �����Ѻ���ʾ��
				Toast.makeText(getApplicationContext(), "����ͼ����...",
						Toast.LENGTH_SHORT).show();
				
				//����ֵ������������
				JsonUnit ju2=new JsonUnit();
				GetPara gp=new GetPara();
				SetPara sp=new SetPara();
				ju2.connServerForResult("http://192.168.68.1:8887/charts/line.php?username="+gp.getPara(v.getContext(),"username")+"&filename="+gp.getPara(v.getContext(),"filename"));
				
				try {
					usedata = new LineUseDataBean();

					usedata.setDateName(getTheName);
					usedata.setDateNum(getTheNum);
					IChart[] mCharts = new IChart[] { new LineChart() };
					intent = mCharts[0].execute(LineChartUI.this);
					startActivity(intent);
				} catch (Exception e) {
					showErrorAlert("		��Ŀ�б�����ֵ,�����룡");
				}
			}
		});

		// ����б��������������ֵ
		linechart_clearList.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				for (int i = 0; i < temp; i++) {
					viewText1[i].setText(null);
					getTheName[i] = null;
					viewText2[i].setText(null);
					for (int j = 0; j < getTheNum[0].length; j++)
						getTheNum[i][j] = -1;
					tableRow[i].removeAllViews();
				}

				linechart_inputName.setText(null);
				for (int i = 0; i < inputnum_editText1.length; i++) {
					inputnum_editText1[i].setText(null);
				}
				temp = 0;
			}
		});
	}

	/**
	 * �жϴ����Ķ�ά�����У���Ч���֣���-1��������������ȡ���ȵģ��Ա��ȥ����Ľ���
	 * 
	 * @param num
	 * @return temp
	 */
	public int howMany(double[][] num, int int1) {
		int hm = 0;
		for (int j = 0; j < num[0].length; j++) {
			if (num[int1][j] != -1) {
				hm++;
			}
		}
		return hm;
	}

	// ��ʼ�������
	private void showErrorAlert(CharSequence message) {
		new AlertDialog.Builder(LineChartUI.this).setTitle("			����")
				.setMessage(message).setPositiveButton("ȷ��",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
							}
						}).setCancelable(false).show();
	}
}