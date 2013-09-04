package net.eusashead.validation.validator;


import java.util.Collections;
import java.util.Map;

import org.springframework.util.Assert;

public class Collaborators {

	private final Map<String, Object> collaborators;

	public Collaborators(Map<String, Object> collaborators) {
		Assert.notNull(collaborators);
		Assert.notEmpty(collaborators);
		this.collaborators = collaborators;
	}

	public Map<String, Object> getCollaborators() {
		return Collections.unmodifiableMap(collaborators);
	}
}
