package utez.edu.com.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.com.libreria.entity.Book;
import utez.edu.com.libreria.services.BookService;

import java.util.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/")
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

    @GetMapping(value = "/bookByGenero/{data}")
    public ResponseEntity<Object> getByGenero(@PathVariable String data){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Book> list = bookService.frinByGenero(data);
            return new ResponseEntity<Object>(list,HttpStatus.OK);
        }catch (Exception e){
            map.put("message: ",e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/bookByFechas/{data1}&{data2}")
    public ResponseEntity<Object> getByfechas(@PathVariable@DateTimeFormat(pattern = "yyyy-MM-dd") Date data1,@PathVariable@DateTimeFormat(pattern = "yyy-MM-dd") Date data2){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Book> list = bookService.findByFechas(data1,data2);
            return new ResponseEntity<Object>(list,HttpStatus.OK);
        }catch (Exception e){
            map.put("message: ",e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/bookBynameOrautor/{data}")
    public ResponseEntity<Object> getByNombreOrautor(@PathVariable String data){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Book> list = bookService.findByNombreOrAutor(data);
            return new ResponseEntity<Object>(list,HttpStatus.OK);
        }catch (Exception e){
            map.put("message: ",e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/bookByFecha/{data}")
    public ResponseEntity<Object> getByfecha(@PathVariable@DateTimeFormat(pattern = "yyyy-MM-dd") Date data){
        Map<String,Object> map = new HashMap<>();
        try {
            List<Book> list = bookService.findByFecha(data);
            return new ResponseEntity<Object>(list,HttpStatus.OK);
        }catch (Exception e){
            map.put("message: ",e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
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
            return null;
        }catch (Exception e){map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);}
    }

    @PostMapping(value = "/")
    public ResponseEntity<Object>save(@RequestBody Book book){
        Book booksave = bookService.save(book);
        return new ResponseEntity(booksave, HttpStatus.CREATED);
    }


}
