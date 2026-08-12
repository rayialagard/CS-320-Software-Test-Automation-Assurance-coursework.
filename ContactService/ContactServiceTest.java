import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        service = new ContactService();

        contact = new Contact(
                "10001",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");
    }

    @Test
    public void testAddContact() {
        service.addContact(contact);

        assertSame(contact, service.getContact("10001"));
    }

    @Test
    public void testCannotAddDuplicateContactId() {
        Contact duplicate = new Contact(
                "10001",
                "Jane",
                "Jones",
                "2255551234",
                "456 Oak Road");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(duplicate);
        });
    }

    @Test
    public void testCannotAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    @Test
    public void testDeleteContact() {
        service.addContact(contact);

        service.deleteContact("10001");

        assertNull(service.getContact("10001"));
    }

    @Test
    public void testCannotDeleteMissingContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("99999");
        });
    }

    @Test
    public void testCannotDeleteNullContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact(null);
        });
    }

    @Test
    public void testUpdateFirstName() {
        service.addContact(contact);

        service.updateFirstName("10001", "Jane");

        assertEquals(
                "Jane",
                service.getContact("10001").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        service.addContact(contact);

        service.updateLastName("10001", "Jones");

        assertEquals(
                "Jones",
                service.getContact("10001").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        service.addContact(contact);

        service.updatePhone("10001", "2255551234");

        assertEquals(
                "2255551234",
                service.getContact("10001").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        service.addContact(contact);

        service.updateAddress("10001", "456 Oak Road");

        assertEquals(
                "456 Oak Road",
                service.getContact("10001").getAddress());
    }

    @Test
    public void testCannotUpdateMissingContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("99999", "Jane");
        });
    }

    @Test
    public void testCannotUpdateWithInvalidValues() {
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("10001", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName("10001", "Abcdefghijk");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("10001", "123456789");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress(
                    "10001",
                    "1234567890123456789012345678901");
        });
    }
}
