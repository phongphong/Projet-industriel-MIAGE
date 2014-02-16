package gameTictactoe.model;
import generic.abstractModel.*;

/**
 * This class represents the tictactoe action, this action contains a player and his sign placement in the grid
 * @author Phongphet
 *
 */
public class TictactoeAction implements GameAction {

	private Player player;
	private int column;
	private int row;
	
	/**
	 * Constructor of TictactoeAction  class
	 * @param player current player
	 * @param column the column in the grid where he places his sign
	 * @param row the row in the grid where he places his sign
	 */
	public TictactoeAction(Player player, int column, int row){
		super();
		this.player = player;
		this.column = column;
		this.row = row;
	}
	
	/**
	 * Getter of player
	 * @return
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Getter of column
	 * @return column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Getter of row
	 * @return row
	 */
	public int getRow() {
		return row;
	}

	@Override
	public String toString() {
		return "[" + player + "," + column + "," + row + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TictactoeAction other = (TictactoeAction) obj;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
}
