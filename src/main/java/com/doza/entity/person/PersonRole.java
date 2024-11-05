package com.doza.entity.person;

public enum PersonRole {
    STUDY(1),
    PERSONAL(2),
    WORKER(3);

    private final int id;

    PersonRole(int id) {
        this.id = id;
    }

    public static PersonRole fromId(int id) {
        for (PersonRole role : values()) {
            if (role.id == id) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown PersonRole id: " + id);
    }
}

