package Model;

import java.util.*;

public interface DAO<T> {

    // CRUD
    boolean create(T obj);
    boolean read(int id);
    boolean update(T obj);
    boolean delete(T obj);

    // ALTRES
    boolean exists(T t);
    int count();
    List<T> all() throws Exception;
}
