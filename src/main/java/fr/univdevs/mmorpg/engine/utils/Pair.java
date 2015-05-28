package fr.univdevs.mmorpg.engine.utils;

/**
 * Class Pair to make a 2-uple
 *
 * @author Vincent Emile
 */
public class Pair<X, Y> {
    public final X x;
    public final Y y;

    public Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        return !(x != null ? !x.equals(pair.x) : pair.x != null) && !(y != null ? !y.equals(pair.y) : pair.y != null);

    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }
}
