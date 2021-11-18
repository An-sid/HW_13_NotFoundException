package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();
    // test data
    Book book = new Book(1, "", 10, "", 100, 2000);

    @Test
    public void shouldDeleteItem() {
        var some= repo.findAll(); // проверяем состояние репозитория
        repo.save(book); // сохраняем новый объект
        repo.removeById(1); // удаляем этот объект
        // проверяем репо на соответствие исходному состоянию:
        assertArrayEquals(some, repo.findAll());
    }

    @Test
    public void exeptionHandling() {
        assertThrows(NotFoundException.class, () -> {
            repo.removeById(123);
        });
    }
}