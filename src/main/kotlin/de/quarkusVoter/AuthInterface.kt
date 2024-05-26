package de.mathisburger.de.quarkusVoter

/**
 * Needs to implemented on e.g. User Entity to integrate voter auth
 * for this auth entity.
 */
interface AuthInterface {
    /**
     * Gets the auth objects interface
     */
    fun getUsername(): String?

    /**
     * Gets all roles of the auth object
     */
    fun getRoles(): Array<String>
}