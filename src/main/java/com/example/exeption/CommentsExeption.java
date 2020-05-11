package com.example.exeption;

public class CommentsExeption extends RuntimeException
{
    private Long commentId;

    public CommentsExeption(Long commentId)
    {
        super(String.format("Комменнтарий не найден", commentId));
    }

    public Long getCommentId() {
        return commentId;
    }
}
