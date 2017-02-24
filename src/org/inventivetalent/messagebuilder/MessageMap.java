package org.inventivetalent.messagebuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MessageMap implements MessageContainer {

	private final Map<String, String> messages = new HashMap<>();

	protected MessageMap(Map<String, String> map) {
		this.messages.putAll(map);
	}

	@Override
	public String getMessage(String key) {
		return messages.get(key);
	}

	@Override
	public String getMessage(String key, Object... format) {
		return messages.containsKey(key) ? String.format(messages.get(key), format) : "";
	}

	@Override
	public String getMessage(String key, ReplacementContainer container) {
		return messages.containsKey(key) ? container.format(messages.get(key)) : "";
	}

	@Override
	public Set<String> getMessages() {
		return new HashSet<>(messages.values());
	}

	@Override
	public Set<String> getMessageKeys() {
		return new HashSet<>(messages.keySet());
	}

}
