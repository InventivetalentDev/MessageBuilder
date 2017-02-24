package org.inventivetalent.messagebuilder;

import java.util.HashMap;
import java.util.Map;

public class ReplacementContainer {

	private Map<String, String> replacements = new HashMap<>();

	public ReplacementContainer() {
	}

	/**
	 * Add a replacement
	 *
	 * @param key         String to replace
	 * @param replacement Replacement for the string
	 * @return the ReplacementContainer
	 */
	public ReplacementContainer replace(String key, String replacement) {
		this.replacements.put(key, replacement);
		return this;
	}

	/**
	 * @return {@link Map} of all replacements
	 */
	public Map<String, String> getReplacements() {
		return new HashMap<>(this.replacements);
	}

	/**
	 * Formats a string
	 *
	 * @param string the {@link String} to format
	 * @return the formatted String
	 */
	public String format(String string) {
		String formatted = string;

		for (Map.Entry<String, String> entry : replacements.entrySet()) {
			formatted = formatted.replace(entry.getKey(), entry.getValue());
		}

		return formatted;
	}

}
