package com.usion.service.impl;

import com.usion.model.User;


public interface PasswordTokenManager {

    /**
     * {@inheritDoc}
     */
    String generateRecoveryToken(User user);

    /**
     * {@inheritDoc}
     */
    boolean isRecoveryTokenValid(User user, String token);

    void invalidateRecoveryToken(User user, String token);
}