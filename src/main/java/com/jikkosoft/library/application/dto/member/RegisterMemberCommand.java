package com.jikkosoft.library.application.dto.member;

/**
 * Command to register a new Member in a specific Library.
 */
public record RegisterMemberCommand(
        Long userId,
        Long libraryId,
        String firstName,
        String lastName,
        String email
) {}
