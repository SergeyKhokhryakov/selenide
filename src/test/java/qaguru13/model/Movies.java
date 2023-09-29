package qaguru13.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Movies {
  private String genre;
  private Movies.Movie[] album;

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Movie{
    private String name,
                  country;
    private String[] actors;             ;
    private int duration;

  }
}
