package com.example.controllers;

import com.example.exeption.RequestExeption;
import com.example.main.Request;
import com.example.repository.RequestRepository;
import com.example.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RequestController {
    @Autowired
    public RequestRepository requestRepository;


    @GetMapping("/requestt")
    public List<Request> getRequests() {
        return requestRepository.findAll();
    }

    @GetMapping(path = {"/requestt/{id}"})
    public Request getRequestById(@PathVariable(value = "id") Long requestId){
        return requestRepository.findById(requestId).orElseThrow(()-> new RequestExeption(requestId));
    }


    @PostMapping("/requestt")
    @ResponseStatus(HttpStatus.CREATED)
    public Request createRequest(@PathVariable String desc)
    {
        return requestRepository.save(new Request(desc));
    }

    @PutMapping("/requestt/{id}/description")
    public void updateRequest(@PathVariable Long requestId, @PathVariable String description)
    {
        Request request = requestRepository.findById(requestId).orElseThrow(()-> new RequestExeption(requestId));
        request.setDescription(description);
        requestRepository.save(request);
    }

    @DeleteMapping("/requestt/{id}")
    public void deleteRequest(@PathVariable Long requestId)
    {
        Request request = requestRepository.findById(requestId).orElseThrow(()-> new RequestExeption(requestId));
        requestRepository.delete(request);
    }

    @PutMapping("/requestt/{id}/status")
    public void updateStatus(Long requestId, Status status)
    {
        Request request = requestRepository.findById(requestId).orElseThrow(()-> new RequestExeption(requestId));
        request.setStatus(status.getStatus());
    }
}
