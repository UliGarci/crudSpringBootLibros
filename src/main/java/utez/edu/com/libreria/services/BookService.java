package utez.edu.com.libreria.services;

import utez.edu.com.libreria.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAll();
    public Book save(Book book);
    public Book findById(Long id);
    public void delete(Book book);
}
