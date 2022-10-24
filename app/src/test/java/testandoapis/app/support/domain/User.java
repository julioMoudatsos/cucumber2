package testandoapis.app.support.domain;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class User {
  @Builder.Default
  private int id = 10;
  @Builder.Default
  private String username = "Jorge";
  @Builder.Default
  private String firstName = "Filho";
  @Builder.Default
  private String lastName = "Jorgao";
  @Builder.Default
  private String email = "Joge@gmail.com";
  @Builder.Default
  private String password = "123456";
  @Builder.Default
  private String phone = "123456";
  @Builder.Default
  private int userStatus = 1;
}
