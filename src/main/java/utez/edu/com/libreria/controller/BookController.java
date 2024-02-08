package utez.edu.com.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.com.libreria.entity.Book;
import utez.edu.com.libreria.services.BookService;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import java.util.HashMap;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public ResponseEntity<Object> get(){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            List<Book> list = bookService.findAll();
            return new ResponseEntity<Object>(list,HttpStatus.OK);
        }catch (Exception e){
            map.put("message: ",e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/book/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try{
            Book book  = bookService.findById(id);
            return new ResponseEntity<Object>(book,HttpStatus.OK);
        }catch (Exception e){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/book/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            Book currentbook = bookService.findById(id);
            bookService.delete(currentbook);
            map.put("deleted",true);
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/book/{id}")
    public ResponseEntity<Object> update(@RequestBody Book book, @PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Book currentPerson = bookService.findById(id);

        }catch (Exception e){map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);}
    }
}
