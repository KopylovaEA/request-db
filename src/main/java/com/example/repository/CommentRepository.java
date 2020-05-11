package com.example.repository;

import com.example.main.Comment;
import com.example.main.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

   List<Comment> findByRequest(Request requesT);
}