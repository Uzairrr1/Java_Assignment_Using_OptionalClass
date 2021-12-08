package PhoneBook;


import com.phonebook.PhoneBookCrawler;
import com.phonebook.PhoneBookEntries;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;


public class PhoneBookCrawlerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private final PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(new PhoneBookEntries());

    @Test
    public void findPhoneNumberByNameAndPunishIfNothingFound()  {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("No phone number found");

        phoneBookCrawler.findPhoneNumberByNameAndPunishIfNothingFound("Shivam");
    }

    @Test
    public void findPhoneNumberByName_AndFindSomething(){
        String phoneNumber = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Akshit");

        assertThat(phoneNumber).isEqualTo("9897999999");
    }

    @Test
    public void findPhoneNumberByNameAndReturnEntirePhoneBookIfNothingFound() {
        String phoneBook = phoneBookCrawler.findPhoneNumberByNameAndPrintPhoneBookIfNothingFound("Shivam");

        assertThat(phoneBook).isEqualTo("PhoneBook{phoneBookEntries={Akshit=9897999999, Shubham=8171989888}}");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_foundByName() {
        String phoneNumber = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Shubham", "12345678");

        assertThat(phoneNumber).isEqualTo("8171989888");
    }

    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumber_foundByPhoneNumber() {
        String name = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Shivam", "8171989888");

        assertThat(name).isEqualTo("Shubham");
    }


}