package Model;

import java.util.*;

public interface DAO<T> {

    // CRUD
    boolean create(T t);
    boolean read(T t);
    boolean update(T t);
    boolean delete(T t);

    // ALTRES
    boolean exists(T t);
    int count();
    List<T> all();
}
