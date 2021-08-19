package homework.lab4.http_request;

public class HttpService {
    public static void handleHttpCode(int httpCode) {
        HttpRequest httpRequest = HttpRequest.findByCode(httpCode);
        httpRequest.handle();
    }
}
