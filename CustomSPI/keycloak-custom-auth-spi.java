package org.example.keycloak.authenticator;

import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.AuthenticationFlowError;
import org.keycloak.authentication.Authenticator;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

public class CustomAuthenticator implements Authenticator {
    @Override
    public void authenticate(AuthenticationFlowContext context) {
        // This method is called when the authenticator is executed
        // Example: Get information from the request
        String customParam = context.getHttpRequest().getDecodedFormParameters().getFirst("custom_param");
        
        // Example: Check if the parameter exists and is valid
        if (customParam != null && isValidCustomParam(customParam)) {
            // Authentication successful
            context.success();
        } else {
            // Authentication failed
            context.failure(AuthenticationFlowError.INVALID_CREDENTIALS);
        }
    }

    private boolean isValidCustomParam(String customParam) {
        // Implement your custom validation logic here
        // This is just a placeholder
        return customParam.equals("valid_value");
    }

    @Override
    public void action(AuthenticationFlowContext context) {
        // This method is called when the form is submitted
        authenticate(context);
    }

    @Override
    public boolean requiresUser() {
        // Return true if this authenticator requires a user to be identified before it can run
        return false;
    }

    @Override
    public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
        // Return true if this authenticator is configured for the user
        return true;
    }

    @Override
    public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
        // Add required actions if necessary
    }

    @Override
    public void close() {
        // Cleanup resources
    }
}
