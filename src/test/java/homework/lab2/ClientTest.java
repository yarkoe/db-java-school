package homework.lab2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void testClientCreation() {
        Client client = new Client.ClientBuilder().setName("Name").setSalary(100).setDebt(10).setBonus(10).build();

        assertEquals("Name", client.getName());
        assertEquals(100, client.getSalary());
        assertEquals(10, client.getDebt());
        assertEquals(10, client.getBonus());
    }
}