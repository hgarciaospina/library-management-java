package com.jikkosoft.library.application.port.service;

import com.jikkosoft.library.domain.model.Member;

/**
 * Port for delivering notifications (email, SMS, push) to users/members.
 */
public interface NotificationPort {

    /**
     * Sends a generic informational message to a member.
     */
    void notifyMember(Member member, String subject, String message);
}
