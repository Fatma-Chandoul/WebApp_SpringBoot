package tn.medcherif.testapi.Model;

import java.io.Serializable;

public enum ERole implements Serializable {
    ROLE_ADMIN("Admin"),
    ROLE_USER("User"),
    ROLE_FATMA("Fatma");
    private final String value;

    ERole(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value + "";
    }
}
