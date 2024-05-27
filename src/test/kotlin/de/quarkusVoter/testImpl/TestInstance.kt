package de.quarkusVoter.testImpl

import de.mathisburger.de.quarkusVoter.VoterInterface
import jakarta.enterprise.inject.Instance
import jakarta.enterprise.util.TypeLiteral

class TestInstance : Instance<VoterInterface> {
    override fun destroy(instance: VoterInterface?) {
        TODO("Not yet implemented")
    }

    override fun iterator(): MutableIterator<VoterInterface> {
        return mutableListOf<VoterInterface>(TestVoter()).iterator();
    }

    override fun get(): VoterInterface {
        TODO("Not yet implemented")
    }

    override fun select(vararg qualifiers: Annotation?): Instance<VoterInterface> {
        TODO("Not yet implemented")
    }

    override fun isUnsatisfied(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAmbiguous(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getHandle(): Instance.Handle<VoterInterface> {
        TODO("Not yet implemented")
    }

    override fun handles(): MutableIterable<Instance.Handle<VoterInterface>> {
        TODO("Not yet implemented")
    }

    override fun <U : VoterInterface?> select(subtype: TypeLiteral<U>?, vararg qualifiers: Annotation?): Instance<U> {
        TODO("Not yet implemented")
    }

    override fun <U : VoterInterface?> select(subtype: Class<U>?, vararg qualifiers: Annotation?): Instance<U> {
        TODO("Not yet implemented")
    }
}