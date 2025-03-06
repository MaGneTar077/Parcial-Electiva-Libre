package com.logs.logs_microservice.Domain.Entity;

import com.logs.logs_microservice.Domain.LogStatus;
import com.logs.logs_microservice.Domain.LogType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Logs {

    private Long Id;

    private String NameMicroSv;
    private String URL;
    private LogStatus Status;

    private String MSJ;

    private LogType Type;
    private String Payload;
    private Date Time;

    public Logs(Long Id, String NameMicroSv, String URL, LogStatus Status, String MSJ, LogType Type, String Payload, Date Time){
        this.Id = Id;
        this.NameMicroSv = NameMicroSv;
        this.URL = URL;
        this.Status = Status;
        this.MSJ = MSJ;
        this.Type =  Type;
        this.Payload = Payload;
        this.Time =  Time;

    }
}
