package com.example.status;

public enum Status {

    NEW ("Новая"),
    IN_WORK("В работе"),
    DONE("Решена"),
    REJECTED("Отклонена");

    private String status;

    Status(String status)
    {
        this.status = status;
    }

    public final String getStatus()
    {
        return status;
    }
}
