package com.example.demo;

public class Usuario {
    private String nickname;
    private String password;
    private int edad;
    //COnstructor
    public Usuario(String nickname, String password, int edad) {
            this.nickname = nickname;
            this.setPassword(password);
            this.edad = edad;
    }
    //Getters y setters

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (isPasswordValid(password)) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("La contraseña debe tener entre 8 y 16 caracteres, al menos una letra mayúscula y al menos un número.");
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    //To String

    @Override
    public String toString() {
        return String.format(
                "Usuario (nickname=%s, password=%s, edad=%s)", this.nickname, this.password, this.edad);
    }

    //No se puede crear usuario si la contraseña no tiene algunas mayuscula, algún numero y tiene que ser entre 8 y 16 caracteres.
    private boolean isPasswordValid(String password) {
        if (password.length() < 8|| password.length()<16) {
            return false;
        }
        boolean tieneMayus=false;
        boolean tieneNum=false;

        for (char c : password.toCharArray()) {
            if(Character.isDigit(c)) {
                tieneNum=true;
            } else if(Character.isUpperCase(c)) {
                tieneMayus=true;
            }
            if(tieneMayus&&tieneNum) {
                return true;
            }
        }
        return false;
    }
}
