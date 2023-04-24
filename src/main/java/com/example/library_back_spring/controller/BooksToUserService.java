package com.example.library_back_spring.controller;

import com.example.library_back_spring.entity.Book;
import com.example.library_back_spring.entity.BooksToUser;
import com.example.library_back_spring.entity.User;
import com.example.library_back_spring.mapper.BooksToUserMapper;
import com.example.library_back_spring.repository.BooksToUserRepository;
import com.example.library_back_spring.view.BooksToUserView;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.Long.parseLong;

@Service
public class BooksToUserService {

    @Resource
    private BookService bookService;

    @Resource
    private UserService userService;

    @Resource
    private BooksToUserMapper booksToUserMapper;

    @Resource
    private BooksToUserRepository booksToUserRepository;

    @Transactional
    public BooksToUserView addNewBorrowing(BooksToUserView booksToUserView) {
        BooksToUser borrowing = booksToUserMapper.toEntity(booksToUserView);
        Book book = bookService.getBookByUnCode(booksToUserView.getUnCode());
        borrowing.setBook(book);

        bookService.updateBookStatusToBorrowed(book);

        User user = userService.getUser(booksToUserView.getPersonalCode());
        borrowing.setUser(user);

        booksToUserRepository.save(borrowing);
        return booksToUserMapper.toDto(borrowing);
    }

    @Transactional
    public void returnBorrowing(String bookUnCode) {

        Long unCode = parseLong(bookUnCode);
        Book book = bookService.getBookByUnCode(unCode);
        bookService.updateBookStatusToAvailable(book);

        BooksToUser bookToUser = booksToUserRepository.findByBook_UnCode(unCode);
        bookToUser.setIsActive(false);
    }
}
