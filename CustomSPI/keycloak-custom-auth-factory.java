package org.example.keycloak.authenticator;

import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.ArrayList;
import java.util.List;

public class CustomAuthenticatorFactory implements AuthenticatorFactory {
    public static final String PROVIDER_ID = "custom-authenticator";
    private static final CustomAuthenticator SINGLETON = new CustomAuthenticator();

    @Override
    public String getDisplayType() {
        return "Custom Authenticator";
    }

    @Override
    public String getReferenceCategory() {
        return "custom";
    }

    @Override
    public boolean isConfigurable() {
        return true;
    }

    @Override
    public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
        return new AuthenticationExecutionModel.Requirement[] {
            AuthenticationExecutionModel.Requirement.REQUIRED,
            AuthenticationExecutionModel.Requirement.ALTERNATIVE,
            AuthenticationExecutionModel.Requirement.DISABLED
        };
    }

    @Override
    public boolean isUserSetupAllowed() {
        return false;
    }

    @Override
    public String getHelpText() {
        return "Custom authenticator that validates a specific parameter.";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        List<ProviderConfigProperty> configProperties = new ArrayList<>();
        
        // Example: Add a configuration property
        ProviderConfigProperty property = new ProviderConfigProperty();
        property.setName("custom_config_param");
        property.setLabel("Custom Configuration Parameter");
        property.setType(ProviderConfigProperty.STRING_TYPE);
        property.setHelpText("Enter a value for the custom configuration parameter");
        configProperties.add(property);
        
        return configProperties;
    }

    @Override
    public Authenticator create(KeycloakSession session) {
        return SINGLETON;
    }

    @Override
    public void init(org.keycloak.Config.Scope config) {
        // Initialize the factory
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
        // Post-initialization if needed
    }

    @Override
    public void close() {
        // Close resources if needed
    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }
}
