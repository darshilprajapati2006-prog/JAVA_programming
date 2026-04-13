package model;

public class Administrator extends User {
    private String adminId;
    private String designation;
    private String fixedPassword;

    public Administrator(
            String id,
            String name,
            String email,
            String password,
            String department,
            String adminId,
            String designation,
            String fixedPassword) {
        super(id, name, email, password, department);
        this.adminId = adminId;
        this.designation = designation;
        this.fixedPassword = fixedPassword;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getFixedPassword() {
        return fixedPassword;
    }

    public void setFixedPassword(String fixedPassword) {
        this.fixedPassword = fixedPassword;
        super.setPassword(fixedPassword);
    }

    public boolean validateFixedPassword(String inputPassword) {
        return fixedPassword != null && fixedPassword.equals(inputPassword);
    }

    @Override
    public String getRoleName() {
        return "Administrator";
    }

    @Override
    public String showBasicProfile() {
        return "Admin ID: " + adminId
                + ", Name: " + getName()
                + ", Designation: " + designation;
    }
}
