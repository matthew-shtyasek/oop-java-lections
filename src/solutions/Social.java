package solutions;

import java.util.*;
import java.util.stream.Collectors;

public class Social {

    public static class User {

        private String name;
        private List<Message> posts;

        public User(String name) {
            this.name = name;
            this.posts = new ArrayList<>();
        }

        public String getName() {
            return this.name;
        }

        public void post(String msg) {
            this.posts.add(0, new Message(this, msg));
        }

        public List<String> getAllMyPosts() {
            return posts.stream().map(Message::getMessage).collect(Collectors.toList());
        }
    }

    public static class Person extends User {

        private String country;

        public Person(String name, String country) {
            super(name);
            this.country = country;
        }

        public String getCountry() {
            return this.country;
        }

        @Override
        public String toString() {
            return super.name;
        }
    }

    public static class Group extends User {

        private String description;
        private Set<Person> subscribers;

        public Group(String name, String description) {
            super(name);
            this.description = description;
            this.subscribers = new HashSet<>();
        }

        public String getInfo() {
            return this.description;
        }

        public void subscribe(Person person) {
            this.subscribers.add(person);
        }

        public void unsubscribe(Person person) {
            this.subscribers.remove(person);
            super.posts.removeIf(post -> post.getUser().equals(person));
        }

        public List<Person> getAllSubs() {
            List<Person> tempList = new ArrayList<>(this.subscribers);
            tempList.sort(Comparator.comparing(User::getName));
            return tempList;
        }

        public void userPost(String msg, Person person) {
            if (isSubscriber(person))
                super.posts.add(0, new Message(person, msg));
            else
                System.out.println("Невозможно опубликовать сообщение");
        }

        public List<String> getAllPosts() {
            return super.getAllMyPosts();
        }

        public List<String> getAllPosts(Person person) {
            if (!isSubscriber(person)) {
                System.out.println("Пользователь не вступил в сообщество");
                return new ArrayList<>();
            }
            return super.posts.stream().filter(message -> message.getUser().equals(person)).map(Message::getMessage).collect(Collectors.toList()); //todo: test
        }

        private boolean isSubscriber(Person person) {
            return subscribers.contains(person);
        }
    }

    public static class Message {

        private User user;
        private String message;

        public Message(User user, String message) {
            this.user = user;
            this.message = message;
        }

        public User getUser() {
            return user;
        }

        public String getMessage() {
            return message;
        }
    }
}
