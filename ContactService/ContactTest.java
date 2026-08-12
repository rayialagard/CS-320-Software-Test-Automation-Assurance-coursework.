import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testCreateContact() {
        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testContactIdAllowsTenCharacters() {
        Contact contact = new Contact(
                "1234567890",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        assertEquals("1234567890", contact.getContactId());
    }

    @Test
    public void testContactIdCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345678901",
                    "John",
                    "Smith",
                    "1234567890",
                    "123 Main Street");
        });
    }

    @Test
    public void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    null,
                    "John",
                    "Smith",
                    "1234567890",
                    "123 Main Street");
        });
    }

    @Test
    public void testFirstNameAllowsTenCharacters() {
        Contact contact = new Contact(
                "12345",
                "Abcdefghij",
                "Smith",
                "1234567890",
                "123 Main Street");

        assertEquals("Abcdefghij", contact.getFirstName());
    }

    @Test
    public void testFirstNameCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Abcdefghijk",
                    "Smith",
                    "1234567890",
                    "123 Main Street");
        });
    }

    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    null,
                    "Smith",
                    "1234567890",
                    "123 Main Street");
        });
    }

    @Test
    public void testLastNameAllowsTenCharacters() {
        Contact contact = new Contact(
                "12345",
                "John",
                "Abcdefghij",
                "1234567890",
                "123 Main Street");

        assertEquals("Abcdefghij", contact.getLastName());
    }

    @Test
    public void testLastNameCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Washingtons",
                    "1234567890",
                    "123 Main Street");
        });
    }

    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    null,
                    "1234567890",
                    "123 Main Street");
        });
    }

    @Test
    public void testPhoneMustContainExactlyTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "123456789",
                    "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "12345678901",
                    "123 Main Street");
        });
    }

    @Test
    public void testPhoneCannotContainLetters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "12345abcde",
                    "123 Main Street");
        });
    }

    @Test
    public void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    null,
                    "123 Main Street");
        });
    }

    @Test
    public void testAddressAllowsThirtyCharacters() {
        String address = "123456789012345678901234567890";

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                address);

        assertEquals(address, contact.getAddress());
    }

    @Test
    public void testAddressCannotBeLongerThanThirtyCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "1234567890",
                    "1234567890123456789012345678901");
        });
    }

    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "1234567890",
                    null);
        });
    }

    @Test
    public void testUpdateFields() {
        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        contact.setFirstName("Jane");
        contact.setLastName("Jones");
        contact.setPhone("2255551234");
        contact.setAddress("456 Oak Road");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Jones", contact.getLastName());
        assertEquals("2255551234", contact.getPhone());
        assertEquals("456 Oak Road", contact.getAddress());
    }

    @Test
    public void testInvalidUpdates() {
        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        assertThrows(IllegalArgumentException.class,
                () -> contact.setFirstName(null));

        assertThrows(IllegalArgumentException.class,
                () -> contact.setLastName("Abcdefghijk"));

        assertThrows(IllegalArgumentException.class,
                () -> contact.setPhone("123456789"));

        assertThrows(IllegalArgumentException.class,
                () -> contact.setAddress(
                        "1234567890123456789012345678901"));
    }
}