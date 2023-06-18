package com.aopprac.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GeneralResponse {
    private boolean responseStatus;
    private String responseMessage;
    private String transactionId;
    private boolean jsonStatus;
    private String emailAddress;
    private String description;
    private int passwordchangeStatus;
    private int number;
}
