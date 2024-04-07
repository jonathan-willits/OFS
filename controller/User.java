package controller;

public class User {
    private int type;
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

    public void set_type(int type) {
        this.type = type;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public void set_password(String password) {
        this.password = password;
    }

    public void set_email(String email) {
        this.email = email;
    }

    public void set_address(String def_address) {
        this.def_address = def_address;
    }

    @Override
    public String toString() {
        return "User [type=" + type + ", name=" + name + ", password=" + password + ", email=" + email
                + ", def_address=" + def_address + "]";
    }

}
