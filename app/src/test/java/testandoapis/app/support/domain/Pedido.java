package testandoapis.app.support.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Pedido {
    @Builder.Default
    private int id = 999;
    @Builder.Default
    private int petId = 198772;
    @Builder.Default
    private int quantity = 7;
    @Builder.Default
    private String shipDate = "2022-10-21T12:36:18.058Z";
    @Builder.Default
    private String status = "approved";
    @Builder.Default
    private Boolean complete = true;
}
