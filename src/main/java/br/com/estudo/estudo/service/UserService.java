package br.com.estudo.estudo.service;

import br.com.estudo.estudo.model.User;
import br.com.estudo.estudo.repository.H2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final H2Repository h2Repository;

    @Autowired
    public UserService(H2Repository h2Repository){
        this.h2Repository = h2Repository;
    }

    public List<User> getUsers(){
        return User.converter(h2Repository.findAll());
    }
    public List<User> getUser(String nome){
        return User.converter(h2Repository.findByNome(nome));
    }
}
