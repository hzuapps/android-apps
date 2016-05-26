package com.example.link2link.board;

import java.util.List;
import com.example.link2link.object.GameConf;
import com.example.link2link.util.ImageUtil;
import com.example.link2link.view.Piece;
import com.example.link2link.view.PieceImage;

/**
 * ������һ��Pieces�����ģ�壬������ȥʵ�־����״̬
 * @author CJP
 *
 */
public abstract class AbstractBoard {

	protected abstract List<Piece> createPieces(GameConf config, Piece[][] pieces);

	public Piece[][] create(GameConf config) {
		// ����һ��Piece[][]����
		Piece[][] pieces = new Piece[config.getXSize()][config.getYSize()];
		// ���طǿյ�Piece���ϣ��ü���������ȥ����
		List<Piece> notNullPieces = createPieces(config, pieces);
		// ���ݷǿ�Piece����ļ��ϵĴ�СȡͼƬ
		List<PieceImage> playImages = ImageUtil.getPlayImages(
				config.getContext(), notNullPieces.size());
		// ��ȡͼƬ�Ŀ��ߣ�����ͼƬ��һ����
		int imageWidth = playImages.get(0).getImage().getWidth();
		int imageHeight = playImages.get(0).getImage().getHeight();
		// �����ǿյ�Piece����,���ü�����ÿ��Piece�����ͼƬ�����Ͻǵ�����
		for (int i = 0; i < notNullPieces.size(); i++) {
			// ���λ�ȡÿ��Piece����
			Piece piece = notNullPieces.get(i);
			piece.setImage(playImages.get(i));
			// ����ÿ�����������Ͻǵ�X��Y���꣨�Ե�һ��ͼƬ��λ��Ϊ��㣩
			piece.setBeginX(piece.getIndexX() * imageWidth
					+ config.getBeginImageX());
			piece.setBeginY(piece.getIndexY() * imageHeight
					+ config.getBeginImageY());
			// ���÷��������뷽���������Ӧλ��
			pieces[piece.getIndexX()][piece.getIndexY()] = piece;
		}
		return pieces;
	}
}
