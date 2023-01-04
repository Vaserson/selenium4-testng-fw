import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.joda.time.LocalDate;
import org.testng.annotations.Test;

import java.util.*;

public class AssertJexaples {

    @Test
    public void stringTest() {
        String temp = "Hello World";
        String a = ""; // NULL
        String b = "   "; // Empty

        Assertions.assertThat(temp)
                .isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .isEqualTo("Hello World")
                .contains("Hello")
                .doesNotContain("Hi")
                .containsWhitespaces()
                .containsIgnoringCase("world")
                .matches("\\w.*"+"World")
                .doesNotContainPattern("\\d.*")
                .hasSize(11)
                .hasSizeGreaterThan(10)
                .hasSizeLessThan(20)
                .hasSizeBetween(10, 20)
                .endsWith("World");

    }

    @Test
    public void numTest() {
        int a = 10;

        Assertions.assertThat(a)
                .isEqualTo(10)
                .isCloseTo(14, Offset.offset(5)) // 10 +- 5
                .isCloseTo( 12, Percentage.withPercentage(30))
                .isNotCloseTo(15, Percentage.withPercentage(30))
                .isInstanceOf(Integer.class)
                .isBetween(5, 15)
                .isPositive()
                .isEven()
                .isGreaterThanOrEqualTo(5)
                .isLessThanOrEqualTo(15);
    }

    @Test
    public void listTest() {
        List<String> list = Arrays.asList("One", "Two", "Three");
        List<String> list2 = Arrays.asList("Ten", "Eleven", "Twelve");
        List<String> list3 = Arrays.asList("One", "Three");

        Assertions.assertThat(list)
                .hasSize(3)
                .hasSizeBetween(2, 5)
                .hasAtLeastOneElementOfType(String.class)
                .isNotEmpty()
                .contains("Two")
                .doesNotContain("Six", "Seven")
                .startsWith("One")
                .containsExactlyInAnyOrder("Two", "One", "Three")
                .containsExactly("One", "Two", "Three")
                .withFailMessage(() -> "String has not size less than 3").allMatch(s->s.length()<3)
                .containsAll(list3)
                .doesNotContainAnyElementsOf(list2);
    }

    @Test
    public void mapTest() {
        Map<String, String> map = new HashMap<>();

        map.put("name", "Vasyl");
        map.put("company", "Global Logic");
        map.put("job", "AQA");

        Assertions.assertThat(map)
                .containsEntry("company", "Global Logic")
                .hasSize(3)
                .isNotEmpty()
                .doesNotContainEntry("game", "soccer")
                .doesNotContainKey("Name")
                .containsKey("job")
                .containsValue("Vasyl");
    }

    @Test
    public void softAssertionsTest() {
        SoftAssertions softAssertion = new SoftAssertions();

        softAssertion.assertThat("Hello World")
                .isNotEmpty()
                .hasSize(5)
                .contains("Hello");

        System.out.println("This will be printed because assertAll() will be calling after");
        softAssertion.assertAll();
    }

    @Test
    public void assertBDDStyleTest() {
        BDDAssertions.then("Hello World")
                .hasSize(11)
                .containsIgnoringCase("hello");
    }

    @Test
    public void objectTest() {
        AssertJClassForTest obj1 = new AssertJClassForTest(33, "Vasyl", 1989);
        AssertJClassForTest obj2 = new AssertJClassForTest(33, "Vasyl", 1989);


        Assertions.assertThat(obj1)
                .isEqualToComparingFieldByField(obj2)
                .isNotNull()
                .isInstanceOf(AssertJClassForTest.class)
                .hasFieldOrProperty("name")
                .hasFieldOrPropertyWithValue("age", 33)
                .extracting(e -> e.getAge()).isNotEqualTo(34);
    }

    @Test
    public void dateTest() {
        // Joda-time => org.joda.time.LocalDate
        /*<groupId>org.assertj</groupId>
        <artifactId>assertj-joda-time</artifactId>
        <version>2.2.0</version>*/
        LocalDate date = new LocalDate(1989,9,6);

        // Doesn't work yet
//        Assertions.assertThat(date)
    }
}
