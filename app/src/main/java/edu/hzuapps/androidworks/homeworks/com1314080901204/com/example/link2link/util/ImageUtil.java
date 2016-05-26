package com.example.link2link.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.link2link.R;
import com.example.link2link.view.PieceImage;

public class ImageUtil {

	// ����һ��List���ڱ�������������ͼƬ��Դ��ID
	private static List<Integer> imageValues = getImageValues();

	// ��ȡ����������ͼƬ��ID
	public static List<Integer> getImageValues() {
		try {
			// ͨ������õ�R.drawable���е����ԣ�����ȡ��drawableĿ¼�µ�����ͼƬ
			Field[] drawableFields = R.drawable.class.getFields();
			// ����һ��List���ڱ�����Ҫ��������������ͼƬ��ID
			List<Integer> resourceValues = new ArrayList<Integer>();
			for (Field field : drawableFields) {
				// �����Field��������p_��ͷ����ȷ�����ڷ���ͼƬ,������ӵ�List��
				if (field.getName().indexOf("p_") != -1) {
					resourceValues.add(field.getInt(R.drawable.class));
				}
			}
			return resourceValues;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * �����sourceValues�ļ����л�ȡsize��ͼƬ�����صĽ��Ϊ�����ȡ��ͼƬ�ļ���
	 * 
	 * @param sourceValues
	 * @param size
	 * @return
	 */
	public static List<Integer> getRandomValues(List<Integer> sourceValues,
			int size) {
		// ����һ����������������������ȡĳһ��ͼƬ
		Random random = new Random();
		// ����������ϣ����ڱ��������ȡ����ͼƬ
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			try {
				// �����ȡһ����0��sourceValues.size()֮�����ֵ
				int index = random.nextInt(sourceValues.size());
				// ���������ҵ���Ӧ��ͼƬ��ԴID
				Integer image = sourceValues.get(index);
				// ������ӵ��������
				result.add(image);
			} catch (IndexOutOfBoundsException e) {
				return result;
			}

		}
		return result;
	}

	/**
	 * ����size��drawableĿ¼�»�ȡͼƬ��Դ�������Ǹ���һ�ݣ�����ɢ�����ڼ����е�λ��
	 * 
	 * @param size
	 * @return
	 */
	public static List<Integer> getPlayValues(int size) {
		if (size % 2 != 0) {
			// ���size����2������0����size��1
			size += 1;
		}
		// �����е�ͼƬ�������ȡsize��һ������
		List<Integer> playImageValues = getRandomValues(imageValues, size / 2);
		// ��playImageValues���ϵ�Ԫ������һ������֤����ͼƬ������֮��Ե�ͼƬ
		playImageValues.addAll(playImageValues);
		// ������������ͼƬ��ɢ
		Collections.shuffle(playImageValues);
		return playImageValues;
	}

	/**
	 * ��ͼƬId����ת����PieceImage���󼯺�
	 * 
	 * @param context
	 * @param size
	 * @return
	 */
	public static List<PieceImage> getPlayImages(Context context, int size) {
		// ��ȡͼƬID��ɵļ���
		List<Integer> resourceValues = getPlayValues(size);
		// �����װ��PieceImage�����ͼƬ��Դ����
		List<PieceImage> result = new ArrayList<PieceImage>();
		for (Integer value : resourceValues) {
			// ����ͼƬ��ID��ͼƬ��װ��Bitmap����
			Bitmap bm = BitmapFactory.decodeResource(context.getResources(),
					value);
			// ��װͼƬId��ͼƬ
			PieceImage pieceImage = new PieceImage(bm, value);
			result.add(pieceImage);
		}
		return result;
	}

	// ��ȡѡ�б�ʶ��ͼƬ
	public static Bitmap getSelectImage(Context context) {
		Bitmap bm = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.selected);
		return bm;
	}
}
