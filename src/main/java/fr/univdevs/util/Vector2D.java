package fr.univdevs.util;

/**
 * Class Vector2D to represent a two dimenstionnal math vector.
 *
 * @author Vincent Emile
 * @author Loïc Payol
 */
public class Vector2D<X extends Number, Y extends Number> {
    /**
     * First element of the vector
     */
    public final X x;

    /**
     * Second element of the vector
     */
    public final Y y;

    public Vector2D(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the first element of the vector
     *
     * @return the first element of the vector
     */
    public X getX() {
        return x;
    }

    /**
     * Returns the second element of the vector
     *
     * @return the second element of the vector
     */
    public Y getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector2D)) return false;

        Vector2D<?, ?> vector2D = (Vector2D<?, ?>) o;

        return !(x != null ? !x.equals(vector2D.x) : vector2D.x != null) && !(y != null ? !y.equals(vector2D.y) : vector2D.y != null);

    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }
}
