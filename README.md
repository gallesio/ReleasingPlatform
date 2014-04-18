Releasing Platform
==================

This is a back up of the code I'm writing for my apprenticeship.

To run the application :

- Start **Wamp** server.
- Start **Mule in standalone mode**.
- Deploy the **Mule app** into the **/apps** directory of Mule server.
- Start **Tomcat** server.
- **Deploy the process** into the **Activiti Explorer**.
6. Open **Postman** on Chrome navigator.
      ```
      POST http://localhost:14000/RCM
      ```
      ```
      {"processDefinitionKey":"releasingProcess"}
      ```

Or go to **http://localhost:13000/RCMUserInterface**, then type ```releasingProcess``` in input field, click on OK button.
