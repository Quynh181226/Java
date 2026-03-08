package petkingdom.bussiness;

import java.util.List;

public interface IGenericRepository<T> {
    T add(T t);

    void remove(String id);

    T findById(String id);

    List<T> findAll();
}