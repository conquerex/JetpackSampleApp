package jetpack.sample.app.data;

/**
 * Created by jongkook on 2020.08.27
 */
public class User {
    private String website;
    private Address address;
    private String phone;
    private String name;
    private Company company;
    private long id;
    private String email;
    private String username;

    public String getWebsite() {
        return website;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}
