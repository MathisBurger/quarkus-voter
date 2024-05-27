package de.quarkusVoter.testImpl

import de.mathisburger.de.quarkusVoter.Votable

class TestEntity : Votable {
    override fun getVotedName(): String {
        return "test"
    }


}