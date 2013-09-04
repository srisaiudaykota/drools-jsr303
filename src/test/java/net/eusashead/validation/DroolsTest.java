package net.eusashead.validation;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import net.eusashead.validation.config.DroolsSpringConfig;
import net.eusashead.validation.form.ApplicationForm;

import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DroolsSpringConfig.class})
public class DroolsTest {

	@Autowired
	private StatelessKnowledgeSession session;
	
	@Autowired 
	private Validator validator;

	@Test
    public void testValidAge() {
        ApplicationForm applicationForm = new ApplicationForm(2, new Date());
        Set<ConstraintViolation<ApplicationForm>> violations = validator.validate(applicationForm);
        Assert.assertNotNull(violations);
        Assert.assertEquals(Integer.valueOf(0), Integer.valueOf(violations.size()));
    }
	
	@Test
    public void testInvalidAge() {
        ApplicationForm applicationForm = new ApplicationForm(1, new Date());
        Set<ConstraintViolation<ApplicationForm>> violations = validator.validate(applicationForm);
        Assert.assertNotNull(violations);
        Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(violations.size()));
    }
}
