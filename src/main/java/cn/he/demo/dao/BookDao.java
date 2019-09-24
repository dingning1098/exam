package cn.he.demo.dao;

import java.util.List;

import cn.he.demo.entity.Book;

public interface BookDao {
	public void save(Book book);
	public void update(Book book);
	public void delete(String id);
	public List<Book> search();
	public Book get(String id);
}
