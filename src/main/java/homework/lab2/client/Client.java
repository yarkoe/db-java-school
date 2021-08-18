package homework.lab2.client;

import lombok.Data;

import static homework.lab2.client.SalaryConstants.DEFAULT_SALARY;

@Data
public class Client {
    private final Contacts contacts;
    private final Salary salary;
    private final int debt;

    private Client (Contacts contacts, Salary salary, int debt) {
        this.contacts = contacts;
        this.salary = salary;
        this.debt = debt;
    }

    public static class ClientBuilder {
        private Contacts contacts;
        private Salary salary = DEFAULT_SALARY;
        private int debt;

        public ClientBuilder contacts(Contacts contacts) {
            this.contacts = contacts;

            return this;
        }

        public ClientBuilder debt(int debt) {
            this.debt = debt;

            return this;
        }

        public ClientBuilder salary(Salary salary) {
            this.salary = salary;

            return this;
        }

        public Client build() {
            if (contacts == null) {
                throw new IllegalArgumentException("You should set contacts");
            }

            return new Client(contacts, salary, debt);
        }
    }
}
