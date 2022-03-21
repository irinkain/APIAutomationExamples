package Data.Responses;

import Data.Requests.BookingDates;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public record BooksResponse(@JsonProperty("firstname") String firstName,
                            @JsonProperty("lastname") String lastName,
                            @JsonProperty("totalprice") int totalPrice,
                            @JsonProperty("depositpaid") boolean depositPaid,
                            @JsonProperty("bookingdates") BookingDates bookingDates,
                            @JsonProperty("additionalneeds") String additionalNeeds,
                            @JsonProperty("id") @JsonInclude(JsonInclude.Include.NON_EMPTY) String id,
                            @JsonProperty("createdAt") @JsonInclude(JsonInclude.Include.NON_EMPTY) String createdAt){
}
