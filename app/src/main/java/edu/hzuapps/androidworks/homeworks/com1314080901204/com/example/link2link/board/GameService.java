package com.example.link2link.board;

import com.example.link2link.object.LinkInfo;
import com.example.link2link.view.Piece;

/**
 * GameSerive��������Ϸ���߼���������Ϸ�Ŀ�ʼ����Ϸ��״̬���߼����жϷ�����
 * 
 * @author CJP
 * 
 */
public interface GameService {

	// ������Ϸ��ʼ
	void start();

	// ������Ϸ״̬������ʣ����Piece����
	Piece[][] getPieces();

	// �ж�Piece[][]�������Ƿ��÷ǿյ�Piece����
	boolean hasPieces();

	// ���ݴ�����������ҳ�Piece����
	Piece findPiece(float touchX, float touchY);

	// �ж�����Piece�Ƿ��������,������ԣ�����LinkInfo���󣬲������򷵻�null
	LinkInfo link(Piece p1, Piece p2);
}
