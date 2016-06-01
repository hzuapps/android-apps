package edu.hzuapps.androidworks.homeworks.net1314080903244;

import com.app.R;
import com.app.FlashlightActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class Net1314080903244Activity extends Activity {
	private Button statusButton = null;
	private Camera camera = null;
	private Parameters parameters = null;
	public static boolean statusFlag = true;
	private int back = 0;// �жϰ�����back

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		statusButton = (Button) findViewById(R.id.statusButton);
		statusButton.setOnClickListener(new Mybutton());
	}

	class Mybutton implements OnClickListener {
		@Override
		public void onClick(View v) {
			if (statusFlag) {
				statusButton.setBackgroundResource(R.drawable.switchon);
				camera = Camera.open();
				parameters = camera.getParameters();
				parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);// ����
				camera.setParameters(parameters);
				statusFlag = false;
			} else {
				statusButton.setBackgroundResource(R.drawable.switchoff);
				parameters.setFlashMode(Parameters.FLASH_MODE_OFF);// �ر�
				camera.setParameters(parameters);
				statusFlag = true;
				camera.release();
			}
		}
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			back++;

			CloseApp();

		}
		return false;// ���ó�false��backʧЧ ��true��ʾ ��ʧЧ

	}

	public void CloseApp() { // �رճ���
		if (statusFlag) {// ���عر�ʱ
			FlashlightActivity.this.finish();
			android.os.Process.killProcess(android.os.Process.myPid());// �رս���
		} else if (!statusFlag) {// ���ش�ʱ
			camera.release();
			FlashlightActivity.this.finish();
			android.os.Process.killProcess(android.os.Process.myPid());// �رս���
			statusFlag = true;// ���⣬�򿪿��غ��˳������ٴν��벻�򿪿���ֱ���˳�ʱ���������
		}
	}
}