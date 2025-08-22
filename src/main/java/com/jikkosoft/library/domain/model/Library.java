package com.jikkosoft.library.domain.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a library.
 * A library can have multiple members, books, and book copies.
 */
public class Library {

    private final Long id;
    private final String name;
    private final String address;
    private final Set<Member> members = new HashSet<>();
    private final Set<BookCopy> bookCopies = new HashSet<>();

    public Library(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public Set<Member> getMembers() { return members; }
    public Set<BookCopy> getBookCopies() { return bookCopies; }

    /**
     * Adds a member to the library.
     * Ensures that a member is not duplicated.
     * @param member Member to add
     */
    public void addMember(Member member) {
        members.add(member);
    }

    /**
     * Adds a book copy to the library's inventory.
     * @param bookCopy BookCopy to add
     */
    public void addBookCopy(BookCopy bookCopy) {
        bookCopies.add(bookCopy);
    }
}
