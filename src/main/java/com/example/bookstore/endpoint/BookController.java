package com.example.bookstore.endpoint;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookDto;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/books")  // łączy adresy url z naszym kontrollerem
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // @RequestMapping(method = RequestMethod.GET, value="/hello")   // zadziala na GET na adres /book/hello
    @GetMapping("/hello")   // krotsza wersja tego co powyzej
    public String hello() {
        return "hello";
    }

    @GetMapping()
    public String listening (Map<String, Object> model){
        model.put("time", new Date());
        model.put("listing", bookService.getListeningData());

        return "book-listing";
    }

    //@PostMapping()
   // public String addBook (@RequestParam("title") String tytul,@RequestParam("author") String autor ){
      //  bookService.addBook(new Book(tytul, autor));
       // return "redirect:/books";
   // }

    @PostMapping()
    public String addBook (@ModelAttribute BookDto bookDto, RedirectAttributes redirectAttributes){
        bookService.addBook(bookDto.fromDto());
        redirectAttributes.addFlashAttribute("result","Ksiązka została dodana"); // dziala tylko jednokrotnie
        return "redirect:/books";
    }
    //@DeleteMapping()
    //public String deleteBook(){
    //}

    @GetMapping("/delete/{id}")
    public String deleteBook (@PathVariable String id, RedirectAttributes redirectAttributes){
        bookService.deleteBook(Integer.parseInt(id)-1);
        redirectAttributes.addFlashAttribute("result","Ksiązka od id " + id + " została usunieta"); // dziala tylko jednokrotnie

        return "redirect:/books";
    }

}
