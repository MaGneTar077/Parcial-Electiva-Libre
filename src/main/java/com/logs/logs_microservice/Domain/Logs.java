package com.logs.logs_microservice.Domain;

import com.fasterxml.jackson.databind.type.LogicalType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.internal.LogManagerStatus;
import java.util.Date;

@Entity
@Getter
@Setter
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String NameMicroSv;
    private String URL;
    private LogStatus Status;

    @Column(length = 200)
    private String MSJ;

    private LogType Type;
    private Date Time;
}
