package net.eusashead.validation.config;

import java.util.HashMap;
import java.util.Map;

import net.eusashead.validation.repository.ApplicantRepository;
import net.eusashead.validation.validator.Collaborators;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class DroolsSpringConfig {
	
	@Bean
	public Validator validator() {
		LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
		return factory;
	}
	
	@Bean 
	public Collaborators collaborators() {
		Map<String, Object> collaborators = new HashMap<String, Object>();
		collaborators.put("applicantRepository", new ApplicantRepository());
		return new Collaborators(collaborators );
	}
	
	@Bean
	public KnowledgeBase knowledgeBase() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("testRule.drl"), ResourceType.DRL);
		if (kbuilder.hasErrors()) {
			throw new RuntimeException(kbuilder.getErrors().toString());
		} 
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}
	
	@Bean
	public StatelessKnowledgeSession statelessKnowledgeSession() {
		return knowledgeBase().newStatelessKnowledgeSession();
	}

}
