package com.aopprac.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MailFormat {
    private String toAddress;
    private String subject;
    private String textBody;
}
