package test;

import cell.Cell;
import org.junit.jupiter.api.Test;
import unit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HealerTests {


    @Test
    void Test05HealerHealsForExpectedAmount(){
        Unit healer = new Healer();
        Unit subject = new TestDummy();

        healer.useAbility(subject);
        //verifico que la unidad fue curada por la cantidad esperada
        assertEquals(((TestDummy) subject).damageReceived(), -15);
    }

}