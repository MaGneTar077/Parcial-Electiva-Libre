package com.logs.logs_microservice.Domain.Entity;

import com.logs.logs_microservice.Domain.Ports.LogStatus;
import com.logs.logs_microservice.Domain.Ports.LogType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String NameMicroSv;
    private String URL;
    private Integer Status;
    private String MSJ;
    private LogType Type;
    private String Payload;
    private Date Time;

    public Log(Long Id, String NameMicroSv, String URL, Integer Status, String MSJ, LogType Type, String Payload, Date Time){
        this.Id = Id;
        this.NameMicroSv = NameMicroSv;
        this.URL = URL;
        this.Status = Status;
        this.MSJ = MSJ;
        this.Type =  Type;
        this.Payload = Payload;
        this.Time =  Time;

    }

    public Log(){

    }
}
