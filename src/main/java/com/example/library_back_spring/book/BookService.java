package com.example.library_back_spring.book;

import com.example.library_back_spring.HTMLTemplateRenderer;
import com.example.library_back_spring.entity.Book;
import com.example.library_back_spring.entity.BookAuthor;
import com.example.library_back_spring.entity.Category;
import com.example.library_back_spring.helper.CodeGenerator;
import com.example.library_back_spring.mapper.BookMapper;
import com.example.library_back_spring.repository.BookAuthorRepository;
import com.example.library_back_spring.repository.BookRepository;
import com.example.library_back_spring.repository.BookStatusRepository;
import com.example.library_back_spring.repository.CategoryRepository;
import com.example.library_back_spring.view.BookView;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class BookService {
     private final HTMLTemplateRenderer htmlTemplateRenderer = new HTMLTemplateRenderer();
    private CodeGenerator codeGenerator = new CodeGenerator();
    @Resource
    private BookRepository bookRepository;
    @Resource
    private BookStatusRepository bookStatusRepository;
    @Resource
    private BookAuthorRepository bookAuthorRepository;
    @Resource
    private CategoryRepository categoryRepository;
    @Resource
    private BookMapper bookMapper;

    public Book addBook(BookView bookView) {
        Book book = bookMapper.toEntity(bookView);
        book.setUnCode(codeGenerator.generate());
        book.setBookStatus(bookStatusRepository.findByDescriptionIgnoreCase("kohal"));
        book.setBookAuthor(assignAuthor(bookView));
        book.setCategory(assignCategory(bookView.getCategory()));
        bookRepository.save(book);
        return book;
    }

    private Category assignCategory(String bookCategoryName) {
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            if (category.getCode().equals(bookCategoryName)) {
                return category;
            }
        }
        return categories.get(0);
    }

    private BookAuthor assignAuthor(BookView bookView) {
        String lastName = bookView.getBookAuthorLastName();
        String firstName = bookView.getBookAuthorFirstName();
        String middleName = bookView.getBookAuthorMiddleName();
        List<BookAuthor> authors = bookAuthorRepository.findByLastName(lastName);
        if (authors.isEmpty()) {
            BookAuthor newBookAuthor = new BookAuthor();
            newBookAuthor.setFirstName(firstName);
            newBookAuthor.setMiddleName(middleName);
            newBookAuthor.setLastName(lastName);
            bookAuthorRepository.save(newBookAuthor);
            return newBookAuthor;
        } else if (authors.size() > 1) {
            for (BookAuthor author : authors) {
                if (author.getFirstName().equals(firstName) && author.getMiddleName().equals(middleName)) {
                    return author;
                }
            }
        }
        return authors.get(0);
    }

    public ModelAndView displayNewBookForm() {
        return new ModelAndView("new");
    }

    public String getBookBy(Integer id) {
        List<Book> books = bookRepository.findById(id).stream().toList();
        for (Book book : books) {
            if (book.getId() == id) {
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
}