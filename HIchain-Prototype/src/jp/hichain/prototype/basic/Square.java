package jp.hichain.prototype.basic;

import java.util.EnumMap;

import jp.hichain.prototype.concept.Direction;
import jp.hichain.prototype.concept.Direction.Relation;

/**
 * 相対マス
 * @author NT
 *
 */
public class Square {
	private Square source;
	private EnumMap <Direction, Square> around;

	/**
	 * ルートマス
	 */
	public Square() {
	}

	/**
	 * 通常のマス
	 * @param _source ソースSquare
	 * @param _dir  ソースからみた自身(this)のAroundDir
	 */
	public Square(Square _source, Direction _dir) {
		source = _source;
		around = new EnumMap<Direction, Square>(Direction.class);
		setAroundAll(_dir.getRelation(Relation.LEFT, 2), _source);
	}

	/**
	 * 周囲Squareを追加
	 * @param _square Square
	 * @param _dir 自身(this)からみた_squareの方向
	 */
	public void addAround(Direction _dir, Square _square) {
		around.put(_dir, _square);
	}

	/**
	 * 指定の方角のSquareを返す
	 * @param _dir 自身(this)からみたAroudDir
	 * @return 周囲Square
	 */
	public Square getAround(Direction _dir) {
		return around.get(_dir);
	}

	/**
	 * 周囲Squareを全て返す
	 * @return 周囲Square Map
	 */
	public EnumMap <Direction, Square> getAroundAll() {
		return around;
	}

	/**
	 * ソースSquareを返す
	 * @return Square
	 */
	public Square getSource() {
		return source;
	}

	private void setAroundAll(Direction _dir, Square _square) {
		addAround(_dir, _square);

	}
}
