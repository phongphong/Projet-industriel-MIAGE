package gameRushHour.model;

import generic.abstractModel.*;
import java.util.Objects;

/**
 * This car represents the action that a player can make in Rushhour game
 * @author Phongphet
 */
public class RushHourAction implements GameAction {
    
    private Car car;
    private int move;

    /**
     * Constructor of RushHourAction class
     * @param car
     * @param moves
     */
    public RushHourAction(Car car, int moves) {
        super();
    	this.car = car;
        this.move = moves;
    }

    /**
     * getter of car
     * @return car
     */
    public Car getCar() {
        return car;
    }

    /**
     * setter of car
     * @param car
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * getter of move
     * @return
     */
    public int getMove() {
        return move;
    }

    /**
     * setter of move
     * @param move
     */
    public void setMove(int move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return "[" + car.getNumber() + ", " + move + ']';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RushHourAction other = (RushHourAction) obj;
        if (!Objects.equals(this.car, other.car)) {
            return false;
        }
        if (this.move != other.move) {
            return false;
        }
        return true;
    }
}
