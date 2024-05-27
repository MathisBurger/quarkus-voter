package de.quarkusVoter.testImpl

import de.mathisburger.de.quarkusVoter.AbstractSecurityService
import de.mathisburger.de.quarkusVoter.AuthInterface
import de.mathisburger.de.quarkusVoter.VoterInterface
import jakarta.enterprise.inject.Instance

class SecurityService(registeredVoters: Instance<VoterInterface>) : AbstractSecurityService(registeredVoters) {

    var user: AuthInterface? = null

    override fun getCurrentAuthObject(): AuthInterface? {
        return user;
    }
}