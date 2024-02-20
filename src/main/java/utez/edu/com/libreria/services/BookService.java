package utez.edu.com.libreria.services;

import utez.edu.com.libreria.entity.Book;

import java.util.Date;
import java.util.List;

public interface BookService {
    public List<Book> findAll();
    public Book save(Book book);
    public Book findById(Long id);
    public void delete(Book book);
    public List<Book> findByNombreOrAutor(String data);
    public List<Book> frinByGenero(String data);
    public List<Book> findByFechas(Date data1, Date data2);
    public List<Book> findByFecha(Date data);
}
