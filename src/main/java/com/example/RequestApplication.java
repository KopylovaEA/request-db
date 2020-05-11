package com.example;

import com.example.controllers.CommentController;
import com.example.controllers.RequestController;
import com.example.main.Comment;
import com.example.main.Request;
import com.example.repository.CommentRepository;
import com.example.repository.RequestRepository;
import com.example.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RequestApplication {

	@Autowired
	public RequestRepository requestRepository;

	@Autowired
	public CommentRepository commentRepository;
	@Autowired
	public CommentController commentController;

	@Autowired
	public RequestController requestController;

	public static void main(String[] args) {
		SpringApplication.run(RequestApplication.class, args);
	}
	/*@EventListener(ApplicationReadyEvent.class)
	private void testJpaMethods(){
		//System.out.println(commentController.getCommentByQuestionId((long)9, (long)15).toString());
		//commentController.getCommentsByQuestionId((long)9).forEach(it->System.out.println(it.getText()));
		//commentController.getCommentsByQuestionId((long)9).forEach(it->System.out.println(it));

		//requestController.deleteRequest((long)22);
		///Request req = new Request();
		requestController.createRequest("new");
        commentController.addComment((long)3, "comment11");
	}*/
	}
