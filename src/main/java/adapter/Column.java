package adapter;

public interface Column<T> {

    String getName();

    String getValue(T o);
}
