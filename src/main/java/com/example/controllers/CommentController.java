package com.example.controllers;

import com.example.exeption.CommentsExeption;
import com.example.exeption.RequestExeption;
import com.example.main.Comment;
import com.example.main.Request;
import com.example.repository.CommentRepository;
import com.example.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CommentController {
    @Autowired
    public CommentRepository commentRepository;
    @Autowired
    public RequestRepository requestRepository;

    @GetMapping("/requestt/{requestId}/commentt")
    public List<Comment> getCommentsByQuestionId(@PathVariable Long requestId) {
        Request req = requestRepository.findById(requestId)
                .orElseThrow(() -> new RequestExeption(requestId));
        return commentRepository.findByRequest(req);
    }

    @GetMapping("/requestt/{requestId}/commentt/{commentId}")
    public Comment getCommentByQuestionId(@PathVariable Long requestId, @PathVariable Long commentId) {
        requestRepository.findById(requestId)
                .orElseThrow(() -> new RequestExeption(requestId));
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentsExeption(commentId));
    }

    @PostMapping("/requestt/{requestId}/commentt")
    public Comment addComment(@PathVariable Long requestId, @PathVariable String comment) {
        Request request = requestRepository.findById(requestId).orElseThrow(() -> new RequestExeption(requestId));
        if(request!=null)
        {
            Comment comm = new Comment(requestId, comment, request);
            return commentRepository.save(comm);
        }
        return null;
    }

    @PutMapping("/requestt/{requestId}/commentt/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @PathVariable String commentUpd) {

        return commentRepository.findById(commentId)
                .map(comment -> {
                    comment.setText(commentUpd);
                    return commentRepository.save(comment);
                }).orElseThrow(()-> new CommentsExeption(commentId));
    }

    @DeleteMapping("/requestt/{requestId}/commentt/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable  Long commentId) {

        return commentRepository.findById(commentId)
                .map(comment -> {
                    commentRepository.delete(comment);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new CommentsExeption(commentId));

    }

}
