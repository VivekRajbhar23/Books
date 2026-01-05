package com.books.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    @Id
    private int bookId;

    private String bookTitle;

    private String bookPrice;

    private int pageCount;

    private String language;

    @OneToOne(cascade = CascadeType.ALL)
    private Authore authore;

}
