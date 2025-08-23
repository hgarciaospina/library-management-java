package com.jikkosoft.library.application.port.tx;

import java.util.function.Supplier;

/**
 * Port to execute a block within a transactional boundary.
 * Infrastructure will provide the concrete implementation (e.g., Spring @Transactional).
 */
public interface TransactionalPort {

    /**
     * Executes a runnable block in a transaction.
     */
    void inTransaction(Runnable runnable);

    /**
     * Executes a function in a transaction and returns its result.
     */
    <T> T inTransactionReturning(Supplier<T> supplier);
}
