import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BonusMilesServiceTest {


    @Test
    void shouldCalculateRegisteredAndUnderLimit() {
        BonusMilesService service = new BonusMilesService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndUnderLimit() {
        BonusMilesService service = new BonusMilesService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndOverLimit() {
        BonusMilesService service = new BonusMilesService();

        long amount = 765543_00;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndOverLimit() {
        BonusMilesService service = new BonusMilesService();

        long amount = 123987_00;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndWIthoutAmount() {
        BonusMilesService service = new BonusMilesService();

        long amount = 0;
        boolean registered = false;
        long expected = 0;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndWIthoutAmount() {
        BonusMilesService service = new BonusMilesService();

        long amount = 0;
        boolean registered = true;
        long expected = 0;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndEqualToLimit() {
        BonusMilesService service = new BonusMilesService();

        long amount = 16666_67;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}