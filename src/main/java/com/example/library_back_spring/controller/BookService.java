package com.example.library_back_spring.controller;

import com.example.library_back_spring.HTMLTemplateRenderer;
import com.example.library_back_spring.entity.Book;
import com.example.library_back_spring.entity.BookAuthor;
import com.example.library_back_spring.entity.Category;
import com.example.library_back_spring.helper.CodeGenerator;
import com.example.library_back_spring.mapper.BookMapper;
import com.example.library_back_spring.repository.BookRepository;
import com.example.library_back_spring.view.BookView;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class BookService {
    private final HTMLTemplateRenderer htmlTemplateRenderer = new HTMLTemplateRenderer();
    private final CodeGenerator codeGenerator = new CodeGenerator();
    @Resource
    private BookStatusService bookStatusService;
    @Resource
    private BookAuthorService bookAuthorService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private BookMapper bookMapper;
    @Resource
    private BookRepository bookRepository;

    public Book addBook(BookView bookView) {
        return mapBookEntityAndSaveToDatabase(bookView);
    }

    private Book mapBookEntityAndSaveToDatabase(BookView bookView) {
        Book book = bookMapper.toEntity(bookView);
        book.setUnCode(codeGenerator.generate());
        book.setBookStatus(bookStatusService.setAsAvailable());
        book.setBookAuthor(assignAuthor(bookView));
        book.setCategory(assignCategory(bookView.getCategory()));
        bookRepository.save(book);
        return book;
    }

    private Category assignCategory(String bookCategoryName) {
        return categoryService.assignCategory(bookCategoryName);
    }

    private BookAuthor assignAuthor(BookView bookView) {
        return bookAuthorService.assignAuthor(bookView);
    }

    public ModelAndView displayNewBookForm() {
        return new ModelAndView("new");
    }

    public String getBookBy(Integer id) {
        List<Book> books = bookRepository.findById(id).stream().toList();
        for (Book book : books) {
            if (book.getId().equals(id)) {
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

    public String getAllBooks() {
        try {
            List<Book> books = bookRepository.findAll();
            return htmlTemplateRenderer.toHtml(books, "templates/index.html");
        } catch (Exception exception) {
            exception.printStackTrace();
            return "Lehekülge ei leitud";
        }
    }

    public List<Book> getBooksByAuthor(String name) {
        return bookRepository.findBookByAuthor(name, name, name);
    }

    public BookView getBookByTitle(String name) {
        Book book = bookRepository.findByTitleIgnoreCase(name);
        return bookMapper.toDto(book);
    }

    public Book getBookByUnCode(Long unCode) {
        return bookRepository.findByUnCode(unCode);
    }

    public void updateBookStatusToBorrowed(Book book) {
        book.setBookStatus(bookStatusService.setAsBorrowed());
    }

    public void updateBookStatusToAvailable(Book book) {
        book.setBookStatus(bookStatusService.setAsAvailable());
    }
}