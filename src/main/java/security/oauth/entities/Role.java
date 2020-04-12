package security.oauth.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    private Integer id;
    @Column(unique = true)
    private String authority;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
    private boolean isDeleted=false;

    public Role() {
    }

    public Role(Integer id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                ", users=" + users +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
