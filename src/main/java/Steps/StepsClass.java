package Steps;

import Data.Responses.BooksResponse;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class StepsClass {
    @Step("Get response")
    public Response getResponse(String body) {
        return given()
                .filter(new AllureRestAssured())
                .contentType("application/json")
                .body(body)
                .when()
                .post("https://reqres.in/api/users");
    }

    @Step("Validate response")
    public void validateResponse(Response response) {
        BooksResponse booksResponse = response.body().as(BooksResponse.class);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Assert.assertEquals("Irina", booksResponse.firstName());
        Assert.assertEquals("Inashvili", booksResponse.lastName());
        Assert.assertEquals(1000, booksResponse.totalPrice());
        Assert.assertTrue(booksResponse.depositPaid());
        Assert.assertEquals(dtf.format(LocalDate.of(2021, 10, 21)),
                booksResponse.bookingDates().checkIn());
        Assert.assertEquals(dtf.format(LocalDate.of(2022, 3, 15)),
                booksResponse.bookingDates().checkOut());
    }


}
