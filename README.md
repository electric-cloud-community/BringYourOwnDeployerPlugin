# BringYourOwnDeployerPlugin
Demo Plugin to demonstrate the third party inventory interface

# Description
Two demo procedures Deploy and Undeploy are included into this plugin for demonstrating the third party inventory interface.
These procedures store information about "deployed" artifacts into ec_deployment_artifacts property of the job in predefined format.
```json
{
  "deploymentSystem": "name of the 3rd-party tool, e.g., Ansible, G3, Gitlab",
  "deploymentUrl": "Url for this deployment job in the 3rd-party tool",
  "artifacts": [
    {
      "artifactName": "artifact1",
      "artifactVersion": "1.2.5",
      "artifactUrl": "Url to the artifact",
      "additionalDetails": {
        "deploymentTargets": "target1, target2",
        "detail1": "value1",
        "detail2": "value2"
      }
    },
    {
      "artifactName": "artifact2",
      "artifactVersion": "3.2.6",
      "artifactUrl": "Url to the artifact",
      "additionalDetails": {
        "deploymentTargets": "target2, target4",
        "detail1": "value1",
        "detail2": "vFalue2"
      }
    }
  ]
}
```
