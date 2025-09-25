package com.teragrep.functions.mvn_01;

// spotless:off
/**
 * @class Cat
 * @brief Meows
 *
 * @responsibilities
 * - Very cute
 *
 * @collaborators
 * - Dog
 *
 * @startuml
 * class Cat {
 *   + meow()
 * }
 *
 * Cat --> Dog : cuteness
 *
 * note right of Cat
 * Responsibilities:
 * - Very cute
 *
 * Collaborators:
 * - Dog
 * end note
 *
 * @enduml
 */
// spotless:on

public final class Cat {

    public void meow() {
        return;
    }
}
