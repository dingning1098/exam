package cn.he.demo.service;

import java.util.List;

import cn.he.demo.entity.Book;

public interface BookService {
	public void save(Book book) throws Exception;
	public void update(Book book) throws Exception;
	public void delete(String id) throws Exception;
	public List<Book> search();
	public Book get(String id);
}
