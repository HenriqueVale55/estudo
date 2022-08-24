package br.com.estudo.estudo.service;

import br.com.estudo.estudo.model.User;
import br.com.estudo.estudo.model.UserData;
import br.com.estudo.estudo.repository.H2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void postUser(User user){
        h2Repository.save(new UserData(user.getNome(), user.getIdade()));
    }
    public void updateUser (User user){
        List<UserData> users = h2Repository.findByNome(user.getNome());
        users.stream().forEach(userData ->{
            userData.setNome(user.getNome());
            userData.setIdade(user.getIdade());
            h2Repository.save(userData);
        });
    }
    public void deleteUser (String nome){
        List<UserData> users = h2Repository.findByNome(nome);
        users.stream().forEach(userData ->{
            h2Repository.deleteById(userData.getId());
        });
    }
}
