package qaguru13;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import qaguru13.model.Employee;
import qaguru13.model.Movies;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class JsonTest {
  ClassLoader cl = FilesTest.class.getClassLoader();
//  ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
    ObjectMapper objectMapper = new ObjectMapper();
    @Test
    void jsonParseTest() throws Exception {
      Gson gson = new Gson();
      try (
              InputStream resource = cl.getResourceAsStream("Employee.json");
              InputStreamReader reader = new InputStreamReader(resource)
      ) {
        JsonObject employee = gson.fromJson(reader, JsonObject.class);
        assertThat(employee.get("age").getAsInt()).isEqualTo(44);
        assertThat(employee.get("lastName").getAsString()).isEqualTo("Simpson");
        assertThat(employee.get("firstName").getAsString()).isEqualTo("Homer");

      }
    }

  @Test
  void jsonEmployeeJacksonParseTest() throws IOException {
//    File file = new File("./src/test/resources/employee.json");
    try (
            InputStream resource = cl.getResourceAsStream("employee.json");
            InputStreamReader reader = new InputStreamReader(resource);
    ) {
      Employee employee = objectMapper.readValue(reader, Employee.class);
      assertThat(employee.getAge()).isEqualTo(44);
      assertThat(employee.getLastName()).isEqualTo("Simpson");
      assertThat(employee.getFirstName()).isEqualTo("Homer");
    }
  }

  @Test
  void jsonMovieJacksonParseTest() throws IOException {
//    File file = new File("./src/test/resources/Movies.json");

    try (
            InputStream resource = cl.getResourceAsStream("Movies.json");
            InputStreamReader reader = new InputStreamReader(resource);
    ) {
      List<Movies> movies = objectMapper.readValue(reader, new TypeReference<>(){});
      assertThat(movies).hasSize(2);
      assertThat(movies.get(0).getGenre()).isEqualTo("Детский");
      assertThat(movies.get(0).getAlbum()[0].getActors()).containsExactly("Санаева", "Быков");
      assertThat(movies.get(1).getAlbum()[1].getActors()[0]).isEqualTo("Банионис");
    }
  }
}
