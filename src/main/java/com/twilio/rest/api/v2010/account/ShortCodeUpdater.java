/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

public class ShortCodeUpdater extends Updater<ShortCode> {
    private String pathAccountSid;
    private final String pathSid;
    private String friendlyName;
    private String apiVersion;
    private URI smsUrl;
    private HttpMethod smsMethod;
    private URI smsFallbackUrl;
    private HttpMethod smsFallbackMethod;

    /**
     * Construct a new ShortCodeUpdater.
     *
     * @param pathSid The unique string that identifies this resource
     */
    public ShortCodeUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Construct a new ShortCodeUpdater.
     *
     * @param pathAccountSid The SID of the Account that created the resource(s) to
     *                       update
     * @param pathSid The unique string that identifies this resource
     */
    public ShortCodeUpdater(final String pathAccountSid,
                            final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathSid = pathSid;
    }

    /**
     * A descriptive string that you created to describe this resource. It can be up
     * to 64 characters long. By default, the `FriendlyName` is the short code..
     *
     * @param friendlyName A string to describe this resource
     * @return this
     */
    public ShortCodeUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The API version to use to start a new TwiML session. Can be: `2010-04-01` or
     * `2008-08-01`..
     *
     * @param apiVersion The API version to use to start a new TwiML session
     * @return this
     */
    public ShortCodeUpdater setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    /**
     * The URL we should call when receiving an incoming SMS message to this short
     * code..
     *
     * @param smsUrl URL Twilio will request when receiving an SMS
     * @return this
     */
    public ShortCodeUpdater setSmsUrl(final URI smsUrl) {
        this.smsUrl = smsUrl;
        return this;
    }

    /**
     * The URL we should call when receiving an incoming SMS message to this short
     * code..
     *
     * @param smsUrl URL Twilio will request when receiving an SMS
     * @return this
     */
    public ShortCodeUpdater setSmsUrl(final String smsUrl) {
        return setSmsUrl(Promoter.uriFromString(smsUrl));
    }

    /**
     * The HTTP method we should use when calling the `sms_url`. Can be: `GET` or
     * `POST`..
     *
     * @param smsMethod HTTP method to use when requesting the sms url
     * @return this
     */
    public ShortCodeUpdater setSmsMethod(final HttpMethod smsMethod) {
        this.smsMethod = smsMethod;
        return this;
    }

    /**
     * The URL that we should call if an error occurs while retrieving or executing
     * the TwiML from `sms_url`..
     *
     * @param smsFallbackUrl URL Twilio will request if an error occurs in
     *                       executing TwiML
     * @return this
     */
    public ShortCodeUpdater setSmsFallbackUrl(final URI smsFallbackUrl) {
        this.smsFallbackUrl = smsFallbackUrl;
        return this;
    }

    /**
     * The URL that we should call if an error occurs while retrieving or executing
     * the TwiML from `sms_url`..
     *
     * @param smsFallbackUrl URL Twilio will request if an error occurs in
     *                       executing TwiML
     * @return this
     */
    public ShortCodeUpdater setSmsFallbackUrl(final String smsFallbackUrl) {
        return setSmsFallbackUrl(Promoter.uriFromString(smsFallbackUrl));
    }

    /**
     * The HTTP method that we should use to call the `sms_fallback_url`. Can be:
     * `GET` or `POST`..
     *
     * @param smsFallbackMethod HTTP method Twilio will use with sms_fallback_url
     * @return this
     */
    public ShortCodeUpdater setSmsFallbackMethod(final HttpMethod smsFallbackMethod) {
        this.smsFallbackMethod = smsFallbackMethod;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated ShortCode
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public ShortCode update(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/SMS/ShortCodes/" + this.pathSid + ".json",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("ShortCode update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return ShortCode.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (apiVersion != null) {
            request.addPostParam("ApiVersion", apiVersion);
        }

        if (smsUrl != null) {
            request.addPostParam("SmsUrl", smsUrl.toString());
        }

        if (smsMethod != null) {
            request.addPostParam("SmsMethod", smsMethod.toString());
        }

        if (smsFallbackUrl != null) {
            request.addPostParam("SmsFallbackUrl", smsFallbackUrl.toString());
        }

        if (smsFallbackMethod != null) {
            request.addPostParam("SmsFallbackMethod", smsFallbackMethod.toString());
        }
    }
}