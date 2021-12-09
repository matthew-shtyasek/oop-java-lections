package solutions;

public class InternetShop {

    public static class User {

        private String name;

        public User(String name) {
            this.name = name;
        }
        public String getLogin() { return this.name; }
        public String showProduct(String name) { return String.format("Описание товара %s", name); }
    }

    public static class Client extends User {

        public Client(String name) {
            super(name);
        }
        public String buy(String name) { return String.format("Товар %s куплен", name); }
    }

    public static class Manager extends User {

        public Manager(String name) {
            super(name);
        }
        public String createProduct(String name) { return String.format("Новый товар %s успешно создан", name); }
        public String updateProduct(String name) { return String.format("Товар %s успешно обновлён", name); }
        public String deleteProduct(String name) { return String.format("Товар %s успешно удалён", name); }
    }

    public static class SuperManager extends Manager {

        public SuperManager(String name) {
            super(name);
        }
        public String setDiscount(int value, Client client) { return String.format("Клиенту %s начислена скидка в размере %d%", client.getLogin(), value); } //TODO: test
    }

    public static class Admin extends User {

        public Admin(String name) {
            super(name);
        }

        public User createUser(String name, String type) {
            switch(type) {
                case "client": return new Client(name);
                case "manager": return new Manager(name);
                case "supermanager": return new SuperManager(name);
                case "admin": return new Admin(name);
            }
            return null;
        }

        public String deleteUser(String name) { return String.format("Пользователь %s успешно удалён", name); }
    }
}
