package edu.hzuapps.androidworks.homeworks.net1314080903124;

import java.util.ArrayList;
import java.util.Calendar;

import models.consumeClass;
import models.incomeClass;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import edu.hzuapps.androidworks.homeworks.net1314080903124.R;

public class Net1314080903124_shouru  extends Activity{
	private TextView addDate = null;
	private Spinner typeSpinner;
	public String addType="";
	private Button addButton;
	private EditText money;
	DatePickerDialog.OnDateSetListener OnDateSetListener ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.net1314080903124_addincome);
		
	    this.typeSpinner = ((Spinner)findViewById(R.id.income_type));
	    ArrayList<String> localArrayList = new ArrayList();
	    localArrayList.add("��������");
	    localArrayList.add("��Ʊ����");
	    localArrayList.add("��������");
	    @SuppressWarnings("unchecked")
		ArrayAdapter<String> localArrayAdapter = new ArrayAdapter(this, R.layout.net1314080903124_spinner_item, R.id.spinnerItem, localArrayList);
	    this.typeSpinner.setAdapter(localArrayAdapter);
	    this.typeSpinner.setPrompt("��ѡ����������");
	    this.typeSpinner.setOnItemSelectedListener(new SpinnerSelected());
	    this.addDate = ((TextView)findViewById(R.id.income_addDate));
	    this.addDate.setOnClickListener(new DateOnClick());
	    this.addButton = ((Button)findViewById(R.id.income_addButton));
	    this.addButton.setOnClickListener(new AddPocketClick());
	    this.money = ((EditText)findViewById(R.id.income_money));
	    
	    OnDateSetListener = new DatePickerDialog.OnDateSetListener()
		{
		    public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
		    {
		    	Net1314080903124_shouru.this.addDate.setText(paramInt1 + "-" + (paramInt2 + 1) + "-" + paramInt3);
		    }
		};
    	
    }
protected Dialog onCreateDialog(int paramInt)
	  {
	    Calendar localCalendar = Calendar.getInstance();
	    int i = localCalendar.get(Calendar.YEAR);
	    int j = localCalendar.get(Calendar.MONTH);
	    int k = localCalendar.get(Calendar.DAY_OF_MONTH);
	    switch (paramInt)
	    {
	    default:
	      return null;
	    case 1:
	    }
	    return new DatePickerDialog(this, this.OnDateSetListener, i, j, k);
	  }	
	
//������ʾ
private void dialog()
	  {
	    new AlertDialog.Builder(this).setTitle("���һ��������?").setMessage("�������ͣ�" + this.addType + "\n�����" + this.money.getText().toString() + "\n�������ڣ�" + this.addDate.getText().toString()).setPositiveButton("ȷ��", new DialogInterface.OnClickListener()
	    {
	      public void onClick(DialogInterface paramDialogInterface, int paramInt)
	      {
	    	  Net1314080903124_shouru.this.setResult(-1);
	        //Net1314080903124_AddEvent.this.addPocket();
	        //ȷ�����
	        incomeClass trade=new incomeClass(0, Float.parseFloat(Net1314080903124_shouru.this.money.getText().toString()), 
	        		Net1314080903124_shouru.this.addDate.getText().toString(), "123", addType, Net1314080903124_shouru.this);
	        
	        trade.trade_add();
	        Toast.makeText(Net1314080903124_shouru.this, "������", 0).show();
	      }
	    }).setNegativeButton("ȡ��", new DialogInterface.OnClickListener()
	    {
	      public void onClick(DialogInterface paramDialogInterface, int paramInt)
	      {
	      }
	    }).show();
	  }


class AddPocketClick implements View.OnClickListener
	  {
	    AddPocketClick()
	    {
	    }

	    public void onClick(View paramView)
	    {
	      if (Net1314080903124_shouru.this.addDate.getText().equals("���ѡ������"))
	      {
	        Toast.makeText(Net1314080903124_shouru.this, "����ѡ����������", 0).show();
	        return;
	      }
	      if (Net1314080903124_shouru.this.money.getText().toString().trim().length() == 0)
	      {
	        Toast.makeText(Net1314080903124_shouru.this, "������д������", 0).show();
	        return;
	      }
	      Net1314080903124_shouru.this.dialog();
	    }
	  }
	
class DateOnClick implements View.OnClickListener
  {
    DateOnClick()
    {

    }

    public void onClick(View paramView)
    {
    	Net1314080903124_shouru.this.showDialog(1);
    }
  }
	
	
class SpinnerSelected implements OnItemSelectedListener
	{
		SpinnerSelected()
		{
		}
		
		@Override
		public void onItemSelected(AdapterView<?> paramAdapterView, View arg1, int paramInt,
				long arg3) {
			// TODO Auto-generated method stub
			 String str = paramAdapterView.getItemAtPosition(paramInt).toString();
			 Net1314080903124_shouru.this.addType = str;
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}