package com.teragrep.sb;

public class PoorProgrammingPractices {
    // Issue: HARD_CODE_PASSWORD Hard coded password found
    private static char[] PASSWORD = {'S','e','c','r','3','t','?'};
    public static void main(String[] args) {
        // Ignored issue: DLS_DEAD_LOCAL_STORE Dead store to possiblyNullBoolean in main(String[])
        int ignoredDeadLocalStore = 1;
        // Issue: NP_BOOLEAN_RETURN_NULL nullBooleanValue() has Boolean return type and returns explicit null
        Boolean possiblyNullBoolean = nullBooleanValue();
        // Issue: UC_USELESS_VOID_METHOD main(String[]) concatenates strings using + in a loop
        String concatenatedString = "";
        for(int i=0; i<=3; i++) {
            concatenatedString += i;
        }
    }

    public static Boolean nullBooleanValue() {
        return null;
    }
}
