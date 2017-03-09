package com.mpp.project.business;

import java.io.Serializable;

public class LendableCopy implements Serializable {
    private String copyId;
    private boolean available;

    public LendableCopy(String copyId, boolean available) {
        this.copyId = copyId;
        this.available = available;
    }

    public String getCopyId() {
        return copyId;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }
}
