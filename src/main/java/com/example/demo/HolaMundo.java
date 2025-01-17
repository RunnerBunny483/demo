package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class HolaMundo {

    @GetMapping("/holi")
    public String saludo(){
        return "HOLAAAA";
    }

    @GetMapping("/adios")
    public String despedida(){
        return "Adios Mundo";
    }

    @GetMapping("/hora")
    public LocalDateTime fecha(){
        LocalDateTime fecha = LocalDateTime.now();
        return fecha;
    }

    @PostMapping("/info")
    public void info(ResponseBody info){

    }

    @PostMapping(value= "/login")
    public String loging (@RequestParam String nickname, @RequestParam String password, @RequestParam int edad){
        String mensaje="";
        if (edad <18){
            mensaje="Eres pequeño";
        }else{
            mensaje="info recibida del nickname: " + nickname;

        }
        return mensaje;
    }

    @PostMapping(value = "/loginObjeto")
    public Usuario loginObjeto(@RequestParam String nickname, @RequestParam String password, @RequestParam int edad){
            Usuario u = new Usuario(nickname,password,edad);
            return u;
    }

    @PostMapping(value = "/loginResponse")
    public ResponseEntity<Usuario> loginResponse(@RequestParam String nickname, @RequestParam String password, @RequestParam int edad){
        Usuario u = new Usuario(nickname,password,edad);
        return ResponseEntity.ok().body(u);
    }
}
