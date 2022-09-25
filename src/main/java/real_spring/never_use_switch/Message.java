package real_spring.never_use_switch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Message {
    private String content;
    private MessageChannel messageChannel;
}
