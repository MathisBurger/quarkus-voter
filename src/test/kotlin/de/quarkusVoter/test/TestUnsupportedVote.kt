package de.quarkusVoter.test

import de.quarkusVoter.testImpl.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

/**
 * Tests if voter throws error on unvoted
 */
class TestUnsupportedVote {

    @Test
    fun testUnsupportedVote() {
        val securityService = SecurityService(TestInstance());
        securityService.user = User("mburger", arrayOf("ADMIN"));
        assertFalse(securityService.isGranted(TestVoter.READ, UnvotedEntity()))
    }
}