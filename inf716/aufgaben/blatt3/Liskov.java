import java.util.Collection;
import java.util.LinkedList;

class UserBase {
    private static int ID = 0;
    protected final int _id;

    public UserBase() {
        this._id = ID++;
    }

    public String getUsername() {
        throw new NoUsernameException();
    }

    public String getEmail() {
        throw new NoEmailException();
    }

    public int getID(){
        return this._id;
    }
}

class RegisteredUser extends UserBase {
    protected String _username;

    public RegisteredUser(String username) {
        super();
        assert(username != null);
        this._username = username;
    }

    @Override
    public String getUsername() {
        return this._username;
    }
}



class User extends RegisteredUser {
    protected String _email;

    public User(String username, String email) {
        super(username);

        assert(email != null);
        this._email = email;
    }

    @Override
    public String getEmail() {
        return this._email;
    }
}

class NoUsernameException extends RuntimeException {
    public NoUsernameException() {
        super("Not registered user has no username");
    }
}

class NoEmailException extends RuntimeException {
    public NoEmailException() {
        super("Not registered user has no email");
    }
}

class NotRegisteredUser extends UserBase {

    public NotRegisteredUser() {
        super();
    }
}

class EnterpriseUser extends RegisteredUser {
    private String _personalAssistant;

    public EnterpriseUser(String username, String personalAssistant) {
        super(username);

        this._personalAssistant = personalAssistant;
    }

    public String getPersonalAssistant() {
        return this._personalAssistant;
    }
}


public class Liskov {
    public static void main(String[] args) {
        final Collection<UserBase> users = new LinkedList<>();
        users.add(new EnterpriseUser("enterprise-customer", "CEO"));
        users.add(new User("max", "max.mustermann@mail.io"));
        users.add(new NotRegisteredUser());

        for (final UserBase user : users) {
            try {
                System.out.println(user.getUsername() + " (" + user.getID() + ")");
            }
            catch (NoUsernameException e) {
                System.err.println("Cannot print user with ID "+user.getID());
            }

        }
    }

}
