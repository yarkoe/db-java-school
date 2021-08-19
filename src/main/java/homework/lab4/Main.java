package homework.lab4;

import homework.lab4.http_request.HttpService;

public class Main {
    public static void main(String[] args) {
        HttpService.handleHttpCode(150);
        HttpService.handleHttpCode(299);
        HttpService.handleHttpCode(350);
        HttpService.handleHttpCode(400);
        HttpService.handleHttpCode(550);
    }
}
