package real_spring;

import lombok.Setter;

public class ShakespeareQuoter implements Quoter {
    @Setter
    private String message;

    @Override
    public void sayQuote() {
        System.out.println("To be or not to be");
    }
}
