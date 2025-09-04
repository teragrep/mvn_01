package com.teragrep.sb;

public class PoorProgrammingPractices {

    public static void main(String[] args) {
        // Ignored issue: DeadLocalStore
        int ignoredDeadLocalStore = 1;
        // Issue: Boolean is null
        Boolean possiblyNullBoolean = nullBooleanValue();
        // Issue: String concatenation in a loop
        String concatenatedString = "";
        for(int i=0; i<=3; i++) {
            concatenatedString += i;
        }
    }

    public static Boolean nullBooleanValue() {
        return null;
    }
}
