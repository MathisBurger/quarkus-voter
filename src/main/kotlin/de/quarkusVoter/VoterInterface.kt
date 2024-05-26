package de.mathisburger.de.quarkusVoter

import com.sun.security.auth.UserPrincipal

/**
 * Handles voter actions
 */
interface VoterInterface {

    /**
     * Votes on a specific attribute
     *
     * @param user The user that should be voted on
     * @param attributeName The attribute like a role or so
     * @param value The value that should be voted on
     */
    fun <T : Votable> voteOnAttribute(user: AuthInterface?, attributeName: String, value: T): Boolean;

    /**
     * Gets the type that is voted on
     */
    fun votedType(): String;
}