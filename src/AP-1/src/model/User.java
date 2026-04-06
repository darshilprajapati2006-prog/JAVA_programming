package model;

public abstract class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String department;

    public User(String id, String name, String email, String password, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean checkPassword(String inputPassword) {
        return password != null && password.equals(inputPassword);
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public abstract String getRoleName();

    public abstract String showBasicProfile();
}
