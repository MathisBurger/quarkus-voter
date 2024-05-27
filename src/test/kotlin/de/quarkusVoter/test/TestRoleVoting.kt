package de.quarkusVoter.test

import de.quarkusVoter.testImpl.SecurityService
import de.quarkusVoter.testImpl.TestInstance
import de.quarkusVoter.testImpl.User
import jakarta.enterprise.inject.Instance
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Tests role voting
 */
class TestRoleVoting {

    @Test
    fun testVoteOnUserWithRole() {
        val securityService = SecurityService(TestInstance());
        securityService.user = User("mburger", arrayOf("ADMIN"));
        assertTrue(securityService.isGranted("ADMIN"))
        assertFalse(securityService.isGranted("OTHER_ROLE"))
    }
}