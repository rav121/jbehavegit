/**
 * 
 */
package competency.center.bdd;

import org.jbehave.core.junit.JUnitStory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
import junit.framework.Assert;
 
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
//import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;
//import competency.center.bdd.
/**
 * @author aradulescu
 *
 */
public class TestAddUserToRepository extends JUnitStory {
	 private final Set<User>    users    = new HashSet<User>();
	 private UserDao            userDao;
	 
	 @Given("$amount products")
	 public void someProducts(final int amount) {
	 for (int i = 0; i < amount; i++) {
	 final User user = new User();
	 user.setName("user " + i);
	 users.add(user);
	 }
	 }
	 
	 @Given("a user repository")
	 public void aUserRepository() {
	 userDao = new UserDao();
	 }
	 
	 @When("When the user adds $amount users to the user repository")
	 public void userAddsUsersToRepository(final int amount) {
	 for (final User user : users) {
	 userDao.save(user);
	 }
	 }
	 
	 @Then("Then the user repository must contain $amount users")
	 public void productMustBeListed(final int amount) {
	 Assert.assertEquals(amount, userDao.findAll().size());
	 }
	 
	 @Override
	 public Configuration configuration() {
	 //return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader())).useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE));
		 return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader())).useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.STATS));
	 }
	 
	 @Override
	 public List<CandidateSteps> candidateSteps() {
	 return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
	 }
	 
	 @Override
	 @Test
	 public void run() throws Throwable {
	 super.run();
	 }

}
