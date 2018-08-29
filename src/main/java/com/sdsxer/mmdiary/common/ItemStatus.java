package com.sdsxer.mmdiary.common;

public enum ItemStatus {

    NORMAL(0), REVOKED(1), VERIFYING(2);

    private int value;

    ItemStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
