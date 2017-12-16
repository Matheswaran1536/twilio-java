/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.converter.Promoter;
import com.twilio.twiml.TwiML;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * TwiML wrapper for {@code <Play>}
 */
public class Play extends TwiML {
    private final Integer loop;
    private final String digits;
    private final URI url;

    /**
     * For XML Serialization/Deserialization
     */
    private Play() {
        this(new Builder());
    }

    /**
     * Create a new {@code <Play>} element
     */
    private Play(Builder b) {
        super("Play", Collections.<TwiML>emptyList(), b.options);
        this.loop = b.loop;
        this.digits = b.digits;
        this.url = b.url;
    }

    /**
     * The body of the TwiML element
     * 
     * @return Element body as a string if present else null
     */
    protected String getElementBody() {
        return this.getUrl() == null ? null : this.getUrl().toString();
    }

    /**
     * Attributes to set on the generated XML element
     * 
     * @return A Map of attribute keys to values
     */
    protected Map<String, String> getElementAttributes() {
        // Preserve order of attributes
        Map<String, String> attrs = new HashMap<>();

        if (this.getLoop() != null) {
            attrs.put("loop", this.getLoop().toString());
        }
        if (this.getDigits() != null) {
            attrs.put("digits", this.getDigits());
        }

        return attrs;
    }

    /**
     * Times to loop media
     * 
     * @return Times to loop media
     */
    public Integer getLoop() {
        return loop;
    }

    /**
     * Play DTMF tones for digits
     * 
     * @return Play DTMF tones for digits
     */
    public String getDigits() {
        return digits;
    }

    /**
     * Media URL
     * 
     * @return Media URL
     */
    public URI getUrl() {
        return url;
    }

    /**
     * Create a new {@code <Play>} element
     */
    public static class Builder {
        private Integer loop;
        private String digits;
        private URI url;
        private Map<String, String> options = new HashMap<>();

        /**
         * Create a {@code <Play>} with url
         */
        public Builder(URI url) {
            this.url = url;
        }

        /**
         * Create a {@code <Play>} with url
         */
        public Builder(String url) {
            this.url = Promoter.uriFromString(url);
        }

        /**
         * Create a {@code <Play>} with child elements
         */
        public Builder() {
        }

        /**
         * Times to loop media
         */
        public Builder loop(Integer loop) {
            this.loop = loop;
            return this;
        }

        /**
         * Play DTMF tones for digits
         */
        public Builder digits(String digits) {
            this.digits = digits;
            return this;
        }

        /**
         * Media URL
         */
        public Builder url(URI url) {
            this.url = url;
            return this;
        }

        /**
         * Media URL
         */
        public Builder url(String url) {
            this.url = Promoter.uriFromString(url);
            return this;
        }

        /**
         * Set additional attributes on this TwiML element that will appear in generated
         * XML.
         */
        public Builder option(String key, String value) {
            this.options.put(key, value);
            return this;
        }

        /**
         * Create and return resulting {@code <Play>} element
         */
        public Play build() {
            return new Play(this);
        }
    }
}