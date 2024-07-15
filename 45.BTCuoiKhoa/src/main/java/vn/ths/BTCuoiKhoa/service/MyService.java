package vn.ths.BTCuoiKhoa.service;

import java.util.List;

public interface MyService<T> {
    public List<T> getAll();
    public T getById(int id);
    public T add(T t);
    public T update(T t);
    public void deleteById(int id);
    public T findByName(String name);
}
