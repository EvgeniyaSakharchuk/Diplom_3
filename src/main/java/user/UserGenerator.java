package user;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static User usersRandomCreate() {
        User user = new User();
        String randomName = RandomStringUtils.randomAlphabetic(10);
        user.setEmail(randomName.toLowerCase() + "@yandex.ru");
        user.setName(randomName.toLowerCase());
        user.setPassword("123456qwerty");
        return user;
    }
}
