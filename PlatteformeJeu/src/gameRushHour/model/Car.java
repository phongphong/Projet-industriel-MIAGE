package gameRushHour.model;

import java.io.Serializable;

/**
 * This class represents a car in Rushhour game
 * @author Phongphet
 */
public class Car implements Serializable {
    
    private char number;
    private int row;
    private int column;
    private int length;
    private char direction;
    private boolean redCar;

    /**
     * Car constructor
     * @param number car's number
     * @param rows position of a car in the game(row)
     * @param column position of a car in the game(column)
     * @param lenght lenght of car
     * @param direction direction of car
     * @param redCar tell if this is a car that a player should move ot exist
     */
    public Car(char number, int rows, int column, int lenght, char direction, boolean redCar) {
        this.number = number;
        this.row = rows;
        this.column = column;
        this.length = lenght;
        this.direction = direction;
        this.redCar = redCar;
    }
    
    /**
     * Car constructor (Use of equals methode)
     * @param num
     */
    public Car(char num){
        this.number = num;
    }

    /**
     * get the car number
     * @return number of car
     */
    public char getNumber() {
        return number;
    }
    
    /**
     * get the position (column) of the car
     * @return column
     */
    public int getColumn() {
        return column;
    }
    
    /**
     * set the position (column) of the car
     * @param new column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * get the position (row) of the car
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * set the position (row) of the car
     * @param number new row
     */
    public void setRow(int number) {
        this.row = number;
    }

    /**
     * get the car lenght
     * @return lenght
     */
    public int getLength() {
        return length;
    }

    /**
     * get the direction of the car
     * @return direction
     */
    public char getDirection() {
        return direction;
    }

    /**
     * This method tells if this car should be existed
     * @return true or false
     */
    public boolean isRedcar() {
        return redCar;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
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
		Car other = (Car) obj;
		if (number != other.number)
			return false;
		return true;
	}

	/**
     * ToString method
     */
    @Override
    public String toString() {
        return "Voiture{" + "num=" + number + ", ligne=" + row + ", col=" + column + ", longeur=" + length + ", direction=" + direction + ", voitureR=" + redCar + '}';
    }
}
