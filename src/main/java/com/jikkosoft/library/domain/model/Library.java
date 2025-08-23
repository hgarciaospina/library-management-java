package com.jikkosoft.library.domain.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Domain model representing a Library.
 *
 * Responsibilities:
 * - Tracks immutable identifiers, name, and address.
 * - Maintains collections of members and book copies (defensive copies).
 * - Integrates with audit tracking via BaseEntity.
 *
 * Validation rules:
 * - name and address cannot be null or blank.
 *
 * Notes:
 * - Builder pattern used for flexible and safe construction.
 * - Collections exposed as unmodifiable sets to preserve encapsulation.
 */
public class Library extends BaseEntity {

    private final Long id;
    private final String name;
    private final String address;
    private final Set<Member> members = new HashSet<>();
    private final Set<BookCopy> bookCopies = new HashSet<>();

    // ======================= Private constructor =======================
    private Library(Builder builder) {
        super();
        if (builder.name == null || builder.name.isBlank()) {
            throw new IllegalArgumentException("Library name cannot be null or blank");
        }
        if (builder.address == null || builder.address.isBlank()) {
            throw new IllegalArgumentException("Library address cannot be null or blank");
        }

        this.id = builder.id;
        this.name = builder.name.trim();
        this.address = builder.address.trim();

        if (builder.members != null) {
            this.members.addAll(builder.members);
        }
        if (builder.bookCopies != null) {
            this.bookCopies.addAll(builder.bookCopies);
        }
    }

    // ======================= Builder =======================
    public static class Builder {
        private Long id;
        private String name;
        private String address;
        private Set<Member> members;
        private Set<BookCopy> bookCopies;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder address(String address) { this.address = address; return this; }
        public Builder members(Set<Member> members) { this.members = members; return this; }
        public Builder bookCopies(Set<BookCopy> bookCopies) { this.bookCopies = bookCopies; return this; }

        public Library build() { return new Library(this); }
    }

    // ======================= Getters =======================
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public Set<Member> getMembers() { return Collections.unmodifiableSet(members); }
    public Set<BookCopy> getBookCopies() { return Collections.unmodifiableSet(bookCopies); }

    // ======================= Domain Methods =======================
    /**
     * Adds a member to the library.
     * Ensures no duplicates are added.
     * @param member Member to add
     */
    public void addMember(Member member) {
        Objects.requireNonNull(member, "Member cannot be null");
        this.members.add(member);
        markUpdated();
    }

    /**
     * Adds a book copy to the library's inventory.
     * Ensures no duplicates are added.
     * @param bookCopy BookCopy to add
     */
    public void addBookCopy(BookCopy bookCopy) {
        Objects.requireNonNull(bookCopy, "BookCopy cannot be null");
        this.bookCopies.add(bookCopy);
        markUpdated();
    }

    // ======================= Equality & Debug =======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library)) return false;
        Library library = (Library) o;
        return name.equalsIgnoreCase(library.name) && address.equalsIgnoreCase(library.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), address.toLowerCase());
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", membersCount=" + members.size() +
                ", bookCopiesCount=" + bookCopies.size() +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", deletedAt=" + getDeletedAt() +
                '}';
    }
}
