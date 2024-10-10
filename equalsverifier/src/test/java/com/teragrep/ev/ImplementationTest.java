package com.teragrep.ev;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class ImplementationTest {
    @Test
    public void testGoodImplementation(){
        GoodImplementation jontti = new GoodImplementation("Jontti", 3);
        GoodImplementation floof = new GoodImplementation("Jontti", 3);
        GoodImplementation otherCat = new GoodImplementation("OrangeCat", 3);
        Assertions.assertEquals(jontti, floof);
        Assertions.assertNotEquals(jontti, otherCat);
        EqualsVerifier.forClass(GoodImplementation.class).verify();
    }

    @Test
    public void testBadImplementation(){
        BadImplementation oldOne = new BadImplementation("The Old One", Integer.MAX_VALUE);
        BadImplementation oldOneCopied = new BadImplementation("The Old One", Integer.MAX_VALUE);
        BadImplementation sleepingOne = new BadImplementation("The Sleeping One", Integer.MAX_VALUE);
        Assertions.assertEquals(oldOne, oldOneCopied);
        Assertions.assertNotEquals(oldOne, sleepingOne);
        EqualsVerifier.forClass(BadImplementation.class).verify();
    }
}
