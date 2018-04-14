package ruszkowski89.springmvc.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.model.Role;
import ruszkowski89.springmvc.model.User;
import ruszkowski89.springmvc.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository repository;

    @Mock
    private PasswordEncoder passwordEncoder;

    private UserServiceImpl service;

    @Before
    public void setup(){
        service = new UserServiceImpl(passwordEncoder, repository);

        User user1 = new User();
        user1.setUserName("Bolek");
        user1.setEmail("bolek@wp.pl");
        user1.setId(1);
        user1.setPassword(passwordEncoder.encode("thisShouldNotBeVisible"));
        user1.setRecipesList(new ArrayList<Recipe>() {});
        user1.setRoles(Arrays.asList(new Role("ROLE_USER")));

        when(service.get("Bolek")).thenReturn(user1);
    }

    @Test
    public void testSave_returnsNewUser(){
        when(repository.save(any(User.class))).thenReturn(new User());

        User user = new User();

        assertThat(service.save(user), is(notNullValue()));
    }

    @Test
    public void whenValidName_thenUserShouldBeFound(){
        User found = service.get("Bolek");
        Assert.assertThat(found.getUserName(), is("Bolek"));
    }
}
