package utez.edu.com.libreria.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import utez.edu.com.libreria.entity.Book;
public interface BookDao extends JpaRepository<Book,Long>{
}
