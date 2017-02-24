package org.inventivetalent.messagebuilder;

import java.util.Set;

public interface MessageContainer {

	/**
	 * Get a specific message
	 *
	 * @param key Message to get
	 * @return the Message
	 */
	String getMessage(String key);

	/**
	 * Get a specific message
	 *
	 * @param key    Message to get
	 * @param format Format for the message
	 * @return the Message
	 */
	String getMessage(String key, Object... format);

	/**
	 * Get a specific message with replacements
	 *
	 * @param key       Message to get
	 * @param container {@link ReplacementContainer} with replacements
	 * @return the Message
	 */
	String getMessage(String key, ReplacementContainer container);

	/**
	 * @return a {@link Set} of all messages
	 */
	Set<String> getMessages();

	/**
	 * @return a {@link Set} of all message keys
	 */
	Set<String> getMessageKeys();

}
