package com.aopprac.service;

import com.aopprac.model.MailFormat;

public interface EmailService {
    void sendSimpleMessage(MailFormat mailFormat);
}
