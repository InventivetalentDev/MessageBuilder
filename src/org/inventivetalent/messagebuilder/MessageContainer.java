package org.inventivetalent.messagebuilder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

public interface MessageContainer {

	/**
	 * Get a specific message
	 *
	 * @param key Message to get
	 * @return the Message
	 */
	String getMessage(@Nonnull String key);

	/**
	 * Get a specific message
	 *
	 * @param key    Message to get
	 * @param format Format for the message
	 * @return the Message
	 */
	@Nullable
	String getMessage(@Nonnull String key, @Nullable Object... format);

	/**
	 * Get a specific message with replacements
	 *
	 * @param key       Message to get
	 * @param container {@link ReplacementContainer} with replacements
	 * @return the Message
	 */
	@Nullable
	String getMessage(@Nonnull String key, @Nonnull ReplacementContainer container);

	/**
	 * @return a {@link Set} of all messages
	 */
	@Nonnull
	Set<String> getMessages();

	/**
	 * @return a {@link Set} of all message keys
	 */
	@Nonnull
	Set<String> getMessageKeys();

}
