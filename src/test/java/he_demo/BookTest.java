package he_demo;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.he.demo.entity.Book;
import cn.he.demo.service.BookService;

public class BookTest {
	static BookService bookservice;

	@BeforeClass
	public static void before() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookservice = ctx.getBean(BookService.class);
	}
	
	@Test
    public void testGetAllBooks() {
        List<Book> books=bookservice.search();
    }

    @Test
    public void testAdd() {
        Book entity=new Book("1", "Hibernate 第七版", 78.1f, "肖同发");
        try {
        	bookservice.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testUpdate() {
        Book entity=new Book("1", "Hibernate 第八版", 78.1f, "肖同发");
        try {
        	bookservice.update(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
