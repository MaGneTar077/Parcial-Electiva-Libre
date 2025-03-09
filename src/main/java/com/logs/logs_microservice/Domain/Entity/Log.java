package com.logs.logs_microservice.Domain.Entity;

import com.logs.logs_microservice.Domain.Ports.LogType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Log")
@Getter
@Setter
public class Log {

    @Id
    private String Id;

    private String NameMicroSv;
    private String URL;
    private Integer Status;
    private String MSJ;
    private LogType Type;
    private String Payload;
    private Date Time;

    public Log(String Id, String NameMicroSv, String URL, String MSJ, LogType Type, String Payload, Date Time) {
        this.Id = Id;
        this.NameMicroSv = NameMicroSv;
        this.URL = URL;
        this.MSJ = MSJ;
        this.Type = Type;
        this.Payload = Payload;
        this.Time = Time;

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNameMicroSv() {
        return NameMicroSv;
    }

    public void setNameMicroSv(String nameMicroSv) {
        NameMicroSv = nameMicroSv;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getMSJ() {
        return MSJ;
    }

    public void setMSJ(String MSJ) {
        this.MSJ = MSJ;
    }

    public LogType getType() {
        return Type;
    }

    public void setType(LogType type) {
        Type = type;
    }

    public String getPayload() {
        return Payload;
    }

    public void setPayload(String payload) {
        Payload = payload;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }
}
