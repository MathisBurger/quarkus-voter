# Quarkus voter
 A simple voter authentification library for the quarkus framework. 
 It is pretty simple and reduced to the required core functionality.
 
## Installation

```xml
<dependency>
  <groupId>de.quarkusVoter</groupId>
  <artifactId>quarkus-voter</artifactId>
  <version>1.0</version>
</dependency>
```


## Usage

**NOTE: The following tutorial is built for java, but it works the same way for kotlin.**

The library always provides the same way to authenticate.

First you have to define the class that should be the class that is authorized.
```java
class User implements AuthInterface {
    
    public String getUsername() {
        // Get username here
        return this.username;
    }
    
    public String getRoles() {
        // Get user roles
        return this.roles;
    }
}
```

Now you have to implement a class that extends from the `AbstractSecurityService`:

```java
@ApplicationScoped
class SecurityService extends AbstractSecurityService {

    /**
     * Initialize all voters that are registered
     */
    @Inject
    public SecurityService(Instance<VoterInterface> voters) {
        super(voters);
    }
    
    @Override
    public AuthInterface getCurrentAuthObject() {
        // gets the current logged-in user here
        return currentUser;
    }
}
```

After that you can start to create your first entity / class that should be voted on

```java
class Address implements Votable {
    
    public String getVotedName() {
        return "address";
    }
}
```

Now you can start to create your first Voter.

```java
class AddressVoter implements VoterInterface {
    
    public String votedType() {
        // Must be same as in the Votable in order to work
        return "address";
    } 
    
    public <Address> boolean voteOnAttribute(AuthInterface user, String attributeName, T value) {
        // handle auth here
    }
}
```

## Contribution

If you want to have features implemented, just create an issue and I will do it as soon as possible.