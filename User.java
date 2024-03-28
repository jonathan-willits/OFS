package controller;

public class User {
    private DatabaseManager db;
    private int id,
    type;
    private String name,
    password,
    email,
    def_address;

    User(String n, String pw, String e, int t){
        this.name = n;
        this.password = pw;
        this.email = e;
        this.type = t;
    }

    public String get_name(){
        return this.name;
    }

    public String get_email(){
        return this.email;
    }

    public String get_password(){
        return this.password;
    }
    
    public String get_address(){
        return this.def_address;
    }

    public int get_type(){
        return this.type;
    }
    }
