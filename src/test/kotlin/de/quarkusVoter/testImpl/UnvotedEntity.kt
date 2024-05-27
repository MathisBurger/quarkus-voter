package de.quarkusVoter.testImpl

import de.mathisburger.de.quarkusVoter.Votable

class UnvotedEntity : Votable {
    override fun getVotedName(): String {
        return "no-voter"
    }
}