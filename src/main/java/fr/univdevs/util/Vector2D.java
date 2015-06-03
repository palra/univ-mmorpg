package fr.univdevs.util;

/**
 * Class Vector2D to represent a two dimenstionnal math vector.
 *
 * @author Vincent Emile
 * @author Loïc Payol
 */
public class Vector2D<T extends Number> {
    /**
     * First element of the vector
     */
    public final T x;

    /**
     * Second element of the vector
     */
    public final T y;

    public Vector2D(T x, T y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the first element of the vector
     *
     * @return the first element of the vector
     */
    public T getX() {
        return x;
    }

    /**
     * Returns the second element of the vector
     *
     * @return the second element of the vector
     */
    public T getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector2D)) return false;

        Vector2D<?> vector2D = (Vector2D<?>) o;

        return !(x != null ? !x.equals(vector2D.x) : vector2D.x != null) && !(y != null ? !y.equals(vector2D.y) : vector2D.y != null);

    }
}
