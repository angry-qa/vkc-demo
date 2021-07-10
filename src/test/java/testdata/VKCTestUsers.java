package testdata;

import models.TestUsers;

public class VKCTestUsers {

    public final TestUsers user1 = TestUsers.builder()
            .login("79000000010")
            .phone("79000000010")
            .build();

    public final TestUsers user2 = TestUsers.builder()
            .username("Чак Норрис")
            .abbrname("Чак Н.")
            .login("chunori@yandex.ru")
            .phone(null)
            .firstName("Чак")
            .lastName("Норрис")
            .build();

}

