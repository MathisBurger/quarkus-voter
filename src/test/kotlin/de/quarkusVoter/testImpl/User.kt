package de.quarkusVoter.testImpl

import de.mathisburger.de.quarkusVoter.AuthInterface

class User : AuthInterface {

    private val username: String;
    private val roles: Array<String>;

    constructor(username: String, roles: Array<String>) {
        this.username = username;
        this.roles = roles;
    }

    override fun getUsername(): String {
        return username;
    }

    override fun getRoles(): Array<String> {
        return roles;
    }
}