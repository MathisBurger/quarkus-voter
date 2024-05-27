package de.mathisburger.de.quarkusVoter

import jakarta.enterprise.inject.Instance
import jakarta.inject.Inject

/**
 * Security service that handles access grants and denies
 */
abstract class AbstractSecurityService constructor(registeredVoters: Instance<VoterInterface>) {

    private val voterMap: HashMap<String, VoterInterface> = HashMap();

    init {
        this.initVoterMap(registeredVoters)
    }

    /**
     * Checks if the current auth object is granted on a specific action
     */
    fun isGranted(attribute: String, entity: Votable? = null): Boolean {
        // Get auth object and return unauthorized (false) if is null
        val authObject = this.getCurrentAuthObject() ?: return false;

        // On empty entity auto perform checks on roles
        if (entity == null) {
            return authObject.getRoles().contains(attribute);
        }
        val voter = this.voterMap[entity.getVotedName()] ?: return false;
        return voter.voteOnAttribute(authObject, attribute, entity);
    }

    /**
     * Print debugs all registered voters
     */
    fun debugVoters() {
        for (voter in voterMap.entries) {
            println(voter.key + " => " + voter.value::class.java);
        }
    }

    /**
     * Initializes all required voters
     */
    private fun initVoterMap(registeredVoters: Instance<VoterInterface>) {
        for (vt in registeredVoters) {
            this.voterMap[vt.votedType()] = vt;
        }
    }

    /**
     * Must be implemented by the user
     * NOTE: Null if not logged in
     */
    abstract fun getCurrentAuthObject(): AuthInterface?
}