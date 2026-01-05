package com.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.entity.Books;

@Repository
public interface BookRepositories extends JpaRepository<Books,Integer>{

}
