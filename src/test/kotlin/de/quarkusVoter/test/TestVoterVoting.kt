package de.quarkusVoter.test

import de.quarkusVoter.testImpl.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Tests general voter voting
 */
class TestVoterVoting {

    @Test
    fun testVoteWithVoter() {
        val securityService = SecurityService(TestInstance());
        securityService.user = User("mburger", arrayOf("ADMIN"));
        val votedInstance = TestEntity();
        assertTrue(securityService.isGranted(TestVoter.READ, votedInstance))
        assertFalse(securityService.isGranted(TestVoter.CREATE, votedInstance))
    }
}