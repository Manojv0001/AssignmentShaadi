package com.example.assignmentshaadi.room;

public enum StatusProfile {

    SHOWN(0),
    ACCEPTED(1),
    DECLINED(2),;

    private int value;
    StatusProfile(int value) {
        this.value = value;
    }
}
