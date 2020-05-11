package com.example.exeption;

public class RequestExeption extends RuntimeException {

    private  Long requestId;

    public RequestExeption(Long requestId)
    {
        super(String.format("Эта заявка не найдена", requestId));
    }
    public Long getRequestId()
    {
        return requestId;
    }

    public void setRequestId(Long requestId)
    {
        this.requestId = requestId;
    }
}
