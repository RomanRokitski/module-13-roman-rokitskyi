package task1;

import java.io.IOException;
import java.net.URI;
import java.util.List;

public class Http {
    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String DELETE_URL = "https://jsonplaceholder.typicode.com/users/1";
    private static final String GET_USER_BY_ID_URL =
            "https://jsonplaceholder.typicode.com/users/2";
    private static final String GET_USER_BY_USERNAME_URL =
            "https://jsonplaceholder.typicode.com/users?username=Antonette";

    public static void main(String[] args) throws IOException, InterruptedException {
        User user = createdefaultUser();
        //створюю юзера
        final User createdUser = HttpUtil.sendPost(URI.create(USERS_URL), user);
        System.out.println("Create user: " + createdUser);

        //видаляю юзера
        final List<User> users = HttpUtil.sendGetResults(URI.create(USERS_URL));
        HttpUtil.sendDelete(URI.create(DELETE_URL), user);
        System.out.println(users);

        //отримую інфу по айді юзера
        final User getUserById = HttpUtil.sendGet(URI.create(String.format("%s?id=%d", GET_USER_BY_ID_URL, createdUser.getId())));
        System.out.println(getUserById);

        //отримую інфу по юзернейм
        final List<User> getUserByName = HttpUtil.sendGetResults(URI.create(GET_USER_BY_USERNAME_URL));
        System.out.println(getUserByName);

        //оновити інфу по юзеру
        final User updateUser = HttpUtil.sendPut(URI.create(GET_USER_BY_ID_URL), updateDefaultUser());
        System.out.println("Create user: " + updateUser);

    }
    private static User createdefaultUser() {
        User user = new User();
        user.setId(1);
        user.setName("Inna");
        user.setUsername("Baglai");
        user.setEmail("inna@gmail.com");
        user.setPhone("493-170-9623 x156");
        user.setWebsite("www.site.com");
        return user;
    }
    private static User updateDefaultUser() {
        User user = new User();
        user.setId(2);
        user.setName("Anton");
        user.setUsername("Ptushkin");
        user.setEmail("toha@gmail.com");
        user.setPhone("555-170-9623 x156");
        user.setWebsite("www.tony.com");
        return user;
    }

}
