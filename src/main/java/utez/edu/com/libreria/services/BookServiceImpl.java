package utez.edu.com.libreria.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utez.edu.com.libreria.entity.Book;
import utez.edu.com.libreria.repository.BookDao;
import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
    public List<Book> findAll(){
        return (List<Book>) bookDao.findAll();
    }

    @Override
    @Transactional
    public Book save(Book book){
        return bookDao.save(book);
    }

    @Override
    public Book findById(Long id){
        return bookDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Book book){
        bookDao.delete(book);
    }
}
