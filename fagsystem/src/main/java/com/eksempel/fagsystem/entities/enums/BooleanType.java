package com.eksempel.fagsystem.entities.enums;

public enum BooleanType {
    FALSE(false),
    TRUE(true);

    private final boolean boolValue;

    BooleanType(boolean boolValue) {
        this.boolValue = boolValue;
    }

    public boolean getBooleanValue(){
        return this.boolValue;
    }

    public static BooleanType getEnumValueFromBoolean(boolean value) {
        return (value) ? TRUE : FALSE;
    }

    public static BooleanType getEnumValueFromShort(short value) {
        if (value < 0 || value > 1)
            throw new IllegalArgumentException("The value must be 0 or 1");
        return (value == 1) ? TRUE : FALSE;
    }
}
