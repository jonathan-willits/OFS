package controller;

public class User {
    private int id, type;
    private String name,
            password,
            email,
            def_address;

    /**
     * Default User Constructor
     * @param n     user name
     * @param pw    user password
     * @param e     user email
     * @param t     user type
     */
    User(String n, String pw, String e, int t) {
        this.name = n;
        this.password = pw;
        this.email = e;
        this.type = t;
    }
    /**
     * User Constructor with id -- use ONLY for returns from db queries: UserManager.get_user()
     * @param i     // user id
     * @param n     // user name
     * @param pw    // user password
     * @param e     // user email
     * @param t     // user type
     * @param d     // user default address
     */
    User(int i, String n, String pw, String e, int t, String d) {
        this.id = i;
        this.name = n;
        this.password = pw;
        this.email = e;
        this.type = t;
        this.def_address = d;
    }

    public int get_id(){
        return this.id;
    }
    
    public String get_name() {
        return this.name;
    }

    public String get_email() {
        return this.email;
    }

    public String get_password() {
        return this.password;
    }

    public String get_address() {
        return this.def_address;
    }

    public int get_type() {
        return this.type;
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

    public void set_type(int type) {
        this.type = type;
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
