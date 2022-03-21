import Data.Requests.BookingDates;
import Data.Requests.BooksRecord;
import Data.Requests.StudentRecord;
import Data.Requests.StudentWithLombok;
import Steps.StepsClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestClass {
    ObjectMapper mapper;
    StepsClass stepsClass = new StepsClass();
    @Test
    public void test() throws JsonProcessingException {
        mapper = new ObjectMapper();
        StudentWithLombok student = new StudentWithLombok();
        student.setAge(15);
        student.setName("john");
        student.setHeight(175);
        student.setLastNAme("doe");
        student.setUniversity("harvard");
        String params = mapper.writeValueAsString(student);
        System.out.println(params);
    }
    @Test
    public void withRecord(){
        StudentRecord student1 = new StudentRecord("Irina","Inashvili", "Tbilisi");
        System.out.println(student1);
    }
    @Test
    public void studentRecordJson() throws JsonProcessingException {
        StudentRecord student2 = new StudentRecord("Alina",null, "Tbilisi");
        mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(student2));
    }
    @Test
    public void deserializationJackson() throws JsonProcessingException {
        StudentWithLombok st;
        String params = "{\"name\":\"john\",\"lastNAme\":\"doe\",\"height\":175.0,\"age\":15,\"university\":\"harvard\"}";
        mapper = new ObjectMapper();
        st = mapper.readValue(params,StudentWithLombok.class);
       // System.out.println(mapper.readValue(params,StudentWithLombok.class));
        System.out.println(st.getHeight());
    }
    @Test
    public void createRequest() throws JsonProcessingException {
        mapper = new ObjectMapper();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        BookingDates dates  = new BookingDates(dtf.format(LocalDate.of(2021, 10, 21)),
                dtf.format(LocalDate.of(2022, 3, 15)));
        BooksRecord booksRequest = new BooksRecord("Irina", "Inashvili", 1000, true,
                dates, "Supper");
        stepsClass.validateResponse(stepsClass.getResponse(mapper.writeValueAsString(booksRequest)));
    }


}
