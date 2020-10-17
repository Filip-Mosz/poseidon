package com.filipmoszczynski.module.books;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //daje informację springowi, że zwracane obiekty java ma przerabiać na json'a
public class BooksController {

    private static final List<BooksEntity> BOOKS_ENTITIES = List.of(
            new BooksEntity().setId(1L).setTitle("Lorem1").setAuthor("Author1"),
            new BooksEntity().setId(2L).setTitle("Fight Earnestly").setAuthor("Hans Talhoffer"),
            new BooksEntity().setId(3L).setTitle("Ars Dimicatoria").setAuthor("Liuthger")
    );

    @GetMapping(value = "/rest/books/{id}")
    public BooksEntity getBook(@PathVariable Long id) {
        return  BOOKS_ENTITIES
                .stream().filter(book -> book.getId().equals(id)).findFirst().get();
    }

    @GetMapping("/rest/books")
    public List<BooksEntity> getBooks() {
        return BOOKS_ENTITIES;
    }
}
