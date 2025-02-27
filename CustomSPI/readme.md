## How to use this Custom Authentication SPI

Build the JAR: Run `mvn clean package` in your project directory.
### Deploy to Keycloak:

Copy the generated JAR file from the target directory to Keycloak's providers directory.
Restart Keycloak or run bin/kc.sh build (for newer Keycloak versions).


### Configure the Authentication Flow:

- Log in to the Keycloak Admin Console.
- Navigate to your realm → Authentication → Flows.
- Either create a new flow or copy an existing one.
- Add your custom authenticator to the flow by clicking "Add execution" and selecting "Custom Authenticator".
- Configure the authenticator as needed.


### Bind the Flow to a Client or Browser Flow:

- For a browser flow, go to Authentication → Bindings.
- For a specific client, go to Clients → [Your Client] → Authentication Flow Overrides.