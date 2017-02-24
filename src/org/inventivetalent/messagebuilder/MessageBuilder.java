package org.inventivetalent.messagebuilder;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MessageBuilder extends Formattable {

	private Map<String, String> messages = new HashMap<>();

	public MessageBuilder() {
	}

	/**
	 * Adds a message
	 *
	 * @param key     message key
	 * @param message content of the message
	 * @return the MessageBuilder
	 */
	public MessageBuilder withMessage(String key, String message) {
		this.messages.put(key, message);
		return this;
	}

	/**
	 * Adds multiple messages
	 *
	 * @param messages {@link Map} of messages to add
	 * @return the MessageBuilder
	 */
	public MessageBuilder withMessages(Map<String, String> messages) {
		this.messages.putAll(messages);
		return this;
	}

	/**
	 * Loads the messages from a configuration section
	 * See <link>https://paste.inventivetalent.org/wazasowane.yml</link> for an example configuration
	 *
	 * @param section Section of the configuration containing the messages
	 * @return the MessageBuilder
	 */
	public MessageBuilder fromConfig(ConfigurationSection section) {
		return fromConfig(section, true);
	}

	/**
	 * Loads the messages from a configuration section
	 * See <link>https://paste.inventivetalent.org/wazasowane.yml</link> for an example configuration
	 *
	 * @param section         Section of the configuration containing the messages
	 * @param translateColors If alternate color codes (&) should get translated
	 * @return the MessageBuilder
	 */
	public MessageBuilder fromConfig(ConfigurationSection section, boolean translateColors) {
		Set<String> keys = section.getKeys(true);
		for (String key : keys) {
			if (section.isString(key)) {
				String message = section.getString(key);
				message = translateColors(format(message), translateColors);
				withMessage(key, message);
			}
		}
		return this;
	}

	/**
	 * Adds a string replacement for text being loaded by {@link #fromConfig(ConfigurationSection)}
	 *
	 * @param key   string to be replaced
	 * @param value replacement
	 * @return the MetaBuilder
	 */
	@Override
	public Formattable withFormat(String key, String value) {
		return super.withFormat(key, value);
	}

	/**
	 * Builds the messages
	 *
	 * @return a new {@link MessageBuilder}
	 */
	public MessageContainer build() {
		return new MessageMap(this.messages);
	}

	protected String translateColors(String string, boolean translate) {
		return translate ? org.bukkit.ChatColor.translateAlternateColorCodes('&', string) : string;
	}
}
