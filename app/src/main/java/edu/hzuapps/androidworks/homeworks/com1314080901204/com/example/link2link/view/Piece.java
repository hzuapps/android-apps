package com.example.link2link.view;

import android.graphics.Point;

/**
 * ��װ����Ϸ�����ϵķ��飬���������ϵ�ͼƬ����������Ͻ����꣬�����ڶ�ά�����е�����ֵ�� 
 * ��������ĵ���ж����������Ƿ���ͬ���߼�
 * 
 * @author CJP
 * 
 */
public class Piece {

	// ��ʾ�÷����ϵ�ͼƬ
	private PieceImage image;
	// �ɷ������Ͻǵ����������������Ϸ�����е�λ��
	// 1.��ʾ�÷�������Ͻǵ�x����
	private int beginX;
	// 2.��ʾ�÷�������Ͻǵ�y����
	private int beginY;
	// �ö�����Piece[][]�����е�һά������ֵ
	private int indexX;
	// �ö�����Piece[][]�����еڶ�ά������ֵ
	private int indexY;

	public Piece(int indexX, int indexY) {
		super();
		this.indexX = indexX;
		this.indexY = indexY;
	}

	public PieceImage getImage() {
		return image;
	}

	public void setImage(PieceImage image) {
		this.image = image;
	}

	public int getBeginX() {
		return beginX;
	}

	public void setBeginX(int beginX) {
		this.beginX = beginX;
	}

	public int getBeginY() {
		return beginY;
	}

	public void setBeginY(int beginY) {
		this.beginY = beginY;
	}

	public int getIndexX() {
		return indexX;
	}

	public void setIndexX(int indexX) {
		this.indexX = indexX;
	}

	public int getIndexY() {
		return indexY;
	}

	public void setIndexY(int indexY) {
		this.indexY = indexY;
	}

	// ��ȡ�÷�������ĵ�
	public Point getCenter() {
		return new Point(getImage().getImage().getWidth() / 2 + getBeginX(),
				getImage().getImage().getHeight() / 2 + getBeginY());
	}

	// �ж����������ϵ�ͼƬ�Ƿ���ͬ
	public boolean isSameImage(Piece other) {
		if (image != null) {
			return image.getImageId() == other.image.getImageId();
		}
		return false;
	}

}
