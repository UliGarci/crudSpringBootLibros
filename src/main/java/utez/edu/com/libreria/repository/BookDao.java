package utez.edu.com.libreria.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import utez.edu.com.libreria.entity.Book;

import java.util.Date;
import java.util.List;

public interface BookDao extends JpaRepository<Book,Long>{

    //consulta por nombre y autor
    @Query(value = "SELECT b FROM Book b WHERE b.autor LIKE %:data% OR b.nombrebook LIKE %:data%")
    List<Book> findBookByAutorOrNombrebook(@Param("data") String data);

    //consulta por genero
    @Query(value = "SELECT b FROM Book b WHERE b.genero = :data")
    List<Book> findBookByGenero(@Param("data") String data);

    //Consulta por fecha
    @Query(value = "SELECT b FROM Book b WHERE b.fecha BETWEEN :data1 AND :data2")
    List<Book> findBookByFechaBetween(Date data1, Date data2);

    @Query(value = "SELECT b FROM Book b WHERE b.fecha = :data")
    List<Book> findBookByFecha(Date data);

}
