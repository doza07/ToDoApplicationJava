package com.doza.entity.account;

public enum AccountStatus {
    USER(1),
    VIP(2),
    ADMIN(3);

    private final int id;

    AccountStatus(int id) {
        this.id = id;
    }

    public static AccountStatus fromId(int id) {
        for (AccountStatus status : values()) {
            if (status.id == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown AccountStatus id: " + id);
    }
}
