package Data.Requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BooksRecord (@JsonProperty("firstname") String firstName,
                           @JsonProperty("lastname") String lastName,
                           @JsonProperty("totalprice") int totalPrice,
                           @JsonProperty("depositpaid") boolean depositPaid,
                           @JsonProperty("bookingdates") BookingDates bookingDates,
                           @JsonProperty("additionalneeds") String additionalNeeds){
}
