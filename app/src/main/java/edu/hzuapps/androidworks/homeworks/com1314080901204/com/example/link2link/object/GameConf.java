package com.example.link2link.object;

import android.content.Context;

/**
 * ������Ϸ��������Ϣ������ÿ��������ͼƬ�Ŀ��ߣ���Ϸ����ʱ�������������һά���ڶ�ά�ĳ��ȣ�
 * Board�е�һ��ͼƬ���ֵ�x��y���꣬��Ϸͨ�ص�ʱ������Ϸ��������
 * 
 * @author CJP
 * 
 */
public class GameConf {
	// ������������ÿ�������ͼƬ�Ŀ���
	public static final int PIECE_WIDTH = 40;
	public static final int PIECE_HEIGHT = 40;
	// ��¼��Ϸ����ʱ�䣨100�룩.
	public static int DEFAULT_TIME = 100;
	// Piece[][]�����һά�ĳ���
	private int xSize;
	// Piece[][]����ڶ�ά�ĳ���
	private int ySize;
	// Board�е�һ��ͼƬ���ֵ�x����
	private int beginImageX;
	// Board�е�һ��ͼƬ���ֵ�y����
	private int beginImageY;
	// ��¼��Ϸ����ʱ��, ��λ�Ǻ���
	private long gameTime;
	private Context context;

	/**
	 * �ṩһ������������
	 * 
	 * @param xSize
	 *            Piece[][]�����һά����
	 * @param ySize
	 *            Piece[][]����ڶ�ά����
	 * @param beginImageX
	 *            Board�е�һ��ͼƬ���ֵ�x����
	 * @param beginImageY
	 *            Board�е�һ��ͼƬ���ֵ�y����
	 * @param gameTime
	 *            ����ÿ�ֵ�ʱ��, ��λ����
	 * @param context
	 *            Ӧ��������
	 */
	public GameConf(int xSize, int ySize, int beginImageX, int beginImageY,
			long gameTime, Context context) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.beginImageX = beginImageX;
		this.beginImageY = beginImageY;
		this.gameTime = gameTime;
		this.context = context;
	}

	public long getGameTime() {
		return gameTime;
	}

	public int getXSize() {
		return xSize;
	}

	public int getYSize() {
		return ySize;
	}

	public int getBeginImageX() {
		return beginImageX;
	}

	public int getBeginImageY() {
		return beginImageY;
	}

	public Context getContext() {
		return context;
	}
}
