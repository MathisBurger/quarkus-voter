package de.mathisburger.de.quarkusVoter

/**
 * Should be implemented on classes in order to make them votable
 */
interface Votable {

    /**
     * Gets the name of this entity for voters
     */
    fun getVotedName(): String
}