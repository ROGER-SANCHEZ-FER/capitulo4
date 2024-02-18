import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CribaTest {

    @Test
    void generarPrimos() {
        int [] primos = Criba.generarPrimos(20);
        int [] primosEsperados = {2, 3, 5, 7, 11, 13, 17, 19};
        assertArrayEquals(primosEsperados, primos);
    }
}