package com.teragrep.functions.mvn_01;

// spotless:off
/**
 * @class Dog
 * @brief Woofs
 *
 * @responsibilities
 * - Very fluffy
 *
 * @collaborators
 * - Cat
 *
 * @startuml
 * class Dog {
 *   + woof()
 * }
 *
 * Dog --> Cat : fluffiness
 *
 * note right of Dog
 * Responsibilities:
 * - Very fluffy
 *
 * Collaborators:
 * - Cat
 * end note
 *
 * @enduml
 */
// spotless:on

public final class Dog {
    public void woof() {
        return;
    }
}
