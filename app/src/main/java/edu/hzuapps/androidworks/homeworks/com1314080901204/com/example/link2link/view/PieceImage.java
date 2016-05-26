package com.example.link2link.view;

import android.graphics.Bitmap;

/**
 * ��װ�˷����ϵ�ͼƬ���ɱ�ʾͼƬ��Bitmap�����ͼƬ��Դ��Id����
 * 
 * @author CJP
 * 
 */
public class PieceImage {

	// ��ʾ�����ϵ�ͼƬ��Bitmap����
	private Bitmap image;
	// ��ʾ�����ϵ�ͼƬ��Դ��Id,��Ϊ�ж����������ϵ�ͼƬ�Ƿ���ͬ�ı�ʶ
	private int imageId;

	public PieceImage(Bitmap image, int imageId) {
		super();
		this.image = image;
		this.imageId = imageId;
	}

	public Bitmap getImage() {
		return image;
	}

	public void setImage(Bitmap image) {
		this.image = image;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

}
