package com.teragrep.functions.mvn_01;

/**
 * @class TestClass
 * @brief TestClass that should be ignored from Doxygen and javadoc output.
 */

public final class TestClass {
    boolean implicitVisibilityDoNothing = false;
    private int privatelyDoNothing = 0;
    public String publiclyDoNothing = "no-op";
    public void DoNothing() {
        return;
    }
    public void DoMoreNothing() {
        return;
    }
}
