package cn.he.demo.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.he.demo.entity.Book;
import cn.he.demo.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping("/search")
	public String search(HttpServletRequest request, HttpServletResponse response) {
		List<Book> books = bookService.search();

		request.setAttribute("books", books);
		return "bookList";
	}

	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response) {
		return "addBook";
	}
	
    @RequestMapping(value = "/save",method = {RequestMethod.POST})
	public String save(Book book,HttpServletRequest request, HttpServletResponse response) throws Exception {
    	if(!StringUtils.isEmpty(book.getId())) {
    		Book bk = bookService.get(book.getId());
    		if(bk != null) {
    			request.setAttribute("message", "该图书已经存在");
    			return "addBook";
    		}
    			
    	}
		
		String id = UUID.randomUUID().toString();
		book.setId(id);
		bookService.save(book);
		request.setAttribute("message", "保存成功");
		return "addBook";
	}
}
