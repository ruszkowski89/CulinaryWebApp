package ruszkowski89.springmvc.service;

import org.springframework.stereotype.Service;
import ruszkowski89.springmvc.model.User;

public interface RegistrationService {

    void registerUser(User user);
}
