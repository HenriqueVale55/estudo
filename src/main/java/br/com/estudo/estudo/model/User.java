package br.com.estudo.estudo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("idade")
    private Integer idade;

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
    public User(UserData userData){
        this.nome = userData.getNome();
        this.idade = userData.getIdade();
    }

    public static List<User> converter (List<UserData> users){
        return users.stream().map(User :: new).collect(Collectors.toList());
    }
}
