package cn.he.demo.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.he.demo.dao.BookDao;
import cn.he.demo.entity.Book;
import cn.he.demo.service.BookService;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	@Transactional(readOnly = false)
	public void save(Book book) throws Exception {
		// TODO Auto-generated method stub
		if(book == null) {
			throw new Exception("书籍不能为空");
		}
		if(StringUtils.isEmpty(book.getName())) {
			throw new Exception("书名不能为空");
		}
		
		bookDao.save(book);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Book book) throws Exception{
		// TODO Auto-generated method stub
		bookDao.update(book);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(String id) throws Exception{
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(id)) {
			throw new Exception("ID不能为空");
		}
		bookDao.delete(id);
	}

	public List<Book> search() {
		// TODO Auto-generated method stub
		return bookDao.search();
	}

	@Override
	public Book get(String id) {
		// TODO Auto-generated method stub
		return bookDao.get(id);
	}

}
