package com.jikkosoft.library.application.usecase.book;

import com.jikkosoft.library.application.port.persistence.AuditLogRepository;
import com.jikkosoft.library.application.port.persistence.BookRepository;
import com.jikkosoft.library.application.port.persistence.CategoryRepository;
import com.jikkosoft.library.application.port.service.ClockPort;
import com.jikkosoft.library.application.port.tx.TransactionalPort;
import com.jikkosoft.library.domain.model.Book;

import java.util.stream.Collectors;

/**
 * Use case to create a new Book aggregate.
 */
public class CreateBookUseCase {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuditLogRepository audit;
    private final ClockPort clock;
    private final TransactionalPort tx;

    public CreateBookUseCase(BookRepository bookRepository,
                             CategoryRepository categoryRepository,
                             AuditLogRepository audit,
                             ClockPort clock,
                             TransactionalPort tx) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.audit = audit;
        this.clock = clock;
        this.tx = tx;
    }

    public BookResponse handle(CreateBookCommand cmd, Long actorUserId) {
        return tx.inTransactionReturning(() -> {
            var category = categoryRepository.findById(cmd.categoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Category not found"));

            // Domain: Book constructor validates ISBN vs year and core invariants
            Book book = new Book(
                    null,
                    cmd.isbn(),
                    cmd.title(),
                    /* authors */ java.util.List.of(),
                    cmd.publicationYear(),
                    category
            );

            var saved = bookRepository.save(book);

            audit.record(actorUserId, "BOOK_CREATED",
                    "Book created: isbn=" + saved.getIsbn().getValue() + ", title=" + saved.getTitle(),
                    clock.now());

            return new BookResponse(
                    saved.getId(),
                    saved.getIsbn().getValue(),
                    saved.getTitle(),
                    saved.getPublicationYear(),
                    saved.getCategory().getName(),
                    saved.getAuthors().stream().map(a -> a.getFirstName() + " " + a.getLastName())
                            .collect(Collectors.toList())
            );
        });
    }
}
