package Model;

import java.sql.SQLException;
import java.util.*;

public interface DAO<T> {

    // CRUD
    boolean create(T obj) throws Exception;
    T read(Long id) throws Exception;
    boolean update(T obj) throws Exception;
    boolean delete(Long id) throws SQLException;

    // ALTRES
    boolean exists(int id) throws Exception;
    int count();
    List<T> all() throws Exception;
}
