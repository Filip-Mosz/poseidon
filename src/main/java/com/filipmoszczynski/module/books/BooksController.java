package com.filipmoszczynski.module.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    public BooksController(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    private final BooksRepository booksRepository;

    @GetMapping(value = "/rest/books/{id}")
    public BooksEntity getBook(@PathVariable Long id) {
        return  booksRepository.findById(id).get();
    }

    @GetMapping("/rest/books")
    public List<BooksEntity> getBooks() {
        return booksRepository.findAll();
    }

    @PostMapping("/rest/books")
    public BooksEntity newBooks(@RequestBody BooksEntity booksEntity) {
        return booksRepository.saveAndFlush(booksEntity);
    }

    @DeleteMapping("/rest/books/{id}")
    public void deleteBooks(@PathVariable Long id) {
        booksRepository.deleteById(id);
    }

    @PutMapping("/rest/books/{id}")
    public BooksEntity updateBooks(@PathVariable Long id,
                                   @RequestBody BooksEntity booksEntity) {
        return booksRepository.saveAndFlush(booksEntity.setId(id));
    }
}
