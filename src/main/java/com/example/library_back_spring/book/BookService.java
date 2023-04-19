package com.example.library_back_spring.book;

import com.example.library_back_spring.HTMLTemplateRenderer;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.parseLong;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();
    private final HTMLTemplateRenderer htmlTemplateRenderer = new HTMLTemplateRenderer();

    public Book addBook(BookView bookView) {
        long newBookId = books.size() + 1;
        Book book = new Book(newBookId, bookView.getTitle(), bookView.getAuthor(), bookView.getYearPublished(), bookView.getGenre());
        books.add(book);
        return book;
    }

    public ModelAndView displayNewBookForm() {
        return new ModelAndView("new");
    }

    public String getBookBy(String id) {
        for (Book book : books) {
            if (book.getId() == parseLong(id)) {
                try {
                    return htmlTemplateRenderer.toHtml(book, "templates/book.html");
                } catch (Exception exception) {
                    exception.printStackTrace();
                    return "Lehekülge ei leitud";
                }
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
