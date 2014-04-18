ReleasingPlatform
=================

1. Start Wamp server.
2. Start Mule in standalone mode.
3. Deploy the Mule app into the /apps directory of Mule server.
4. Start Tomcat server.
5. Deploy the process into the Activiti Explorer.
6. Open Postman on Chrome navigator.
      POST http://localhost:14000/RCM
      {"processDefinitionKey":"releasingProcess"}
Or go to http://localhost:13000/RCMUserInterface, then type releasingProcecss in input field, click on OK button.
