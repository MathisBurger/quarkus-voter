package de.quarkusVoter.testImpl

import de.mathisburger.de.quarkusVoter.AuthInterface
import de.mathisburger.de.quarkusVoter.Votable
import de.mathisburger.de.quarkusVoter.VoterInterface

class TestVoter : VoterInterface {

    companion object {
        val CREATE = "CREATE";
        val READ = "READ";
    }

    override fun <T : Votable> voteOnAttribute(user: AuthInterface?, attributeName: String, value: T): Boolean {
        if (user == null) {
            return false
        }
        if (attributeName === TestVoter.READ) {
            return user.getRoles().contains("ADMIN");
        }
        if (attributeName === TestVoter.CREATE) {
            return user.getRoles().contains("OTHER_ROLE");
        }
        return false;
    }

    override fun votedType(): String {
        return "test";
    }
}