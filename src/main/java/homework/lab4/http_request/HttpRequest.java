package homework.lab4.http_request;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HttpRequest {
    INFORMATIONAL(100, 199, () -> System.out.println("Informational")),
    SUCCESS(200, 299, () -> System.out.println("Success")),
    REDIRECTION(300, 399, () -> System.out.println("Redirection")),
    CLIENT_ERROR(400, 499, () -> System.out.println("Client Error")),
    SERVER_ERROR(500, 599, () -> System.out.println("Server Error"));

    private final int leftBorder;
    private final int rightBorder;
    private final Runnable handler;

    public void handle() {
        handler.run();
    }

    public static HttpRequest findByCode(int code) {
        if (code < 100 || code > 599) {
            throw new IllegalArgumentException();
        }

        HttpRequest[] httpRequests = values();
        for (HttpRequest httpRequest : httpRequests) {
            if (httpRequest.leftBorder <= code && httpRequest.rightBorder >= code) {
                return httpRequest;
            }
        }

        throw new IllegalArgumentException(code + " not supported");
    }
}
