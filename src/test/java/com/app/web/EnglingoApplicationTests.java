package com.app.web;

import com.app.web.model.Role;
import com.app.web.model.User;
import com.app.web.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class EnglingoApplicationTests {

    @Autowired
    UserService userService;

    private final String USERNAME = "milan";

    @Test
    public void ulozUzivatele() {
        User novyUzivatel = vytvorUzivatele();
        int pocetPuvodne = userService.findAll().size();
        userService.save(novyUzivatel);
        int pocetPoPridani = userService.findAll().size();
        assertNotEquals(pocetPuvodne, pocetPoPridani);
        userService.delete(novyUzivatel);
    }

    @Test
    public void najdiUzivatelePodleJmena() {
        User novyUzivatel = vytvorUzivatele();
        userService.save(novyUzivatel);
        Optional<User> user = userService.findUserByName(USERNAME);
        assertNotNull(user);
        userService.delete(novyUzivatel);
    }

    private User vytvorUzivatele(){
        User user = new User();
        user.setFirstName("Milan");
        user.setLastName("Petr");
        user.setActive(true);
        Role role = new Role();
        role.setIdRole(2);
        role.setRoleType("USER");
        user.setRole(role);
        user.setEmail("petr@gmail.com");
        user.setUsername("milan");
        user.setPassword(USERNAME);
        return user;
    }

}

