package Model;

import java.util.*;

public interface DAO<T> {

    // CRUD
    boolean create(T obj) throws Exception;
    T read(int id);
    boolean update(T obj);
    boolean delete(T obj);

    // ALTRES
    boolean exists(int id) throws Exception;
    int count();
    List<T> all() throws Exception;
}
