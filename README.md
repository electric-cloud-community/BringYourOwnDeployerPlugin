# BringYourOwnDeployerPlugin
Used to deploy and undeploy artifacts using CloudBees CD/RO's third-party inventory interface.

# Description
To demonstrate CloudBees CD/RO's third-party inventory interface, this plugin includes two procedures:
- `Deploy`
- `Undeploy`

These procedures store information about artifacts into the `ec_deployment_artifacts` property of your job in predefined format based on your JSON input.

# Deploying BringYourOwnDeployerPlugin

For each release of this plugin, a `.jar` is included that can be uploaded to your CloudBees CD/RO instance following the instructions for [Installing a plugin from a file](https://docs.cloudbees.com/docs/cloudbees-cd/latest/plugin-manager/install-plugins#_installing_a_plugin_from_a_file). Once your plugin's `.jar` has been uploaded, you need to configure the plugin for use.

# Plugin configurations
Plugin configurations are sets of parameters that can be applied across some, or all, of the plugin procedures. They can reduce the repetition of common values, create predefined parameter sets, and securely store credentials. Each configuration is given a unique name that is entered in the designated parameter for the plugin procedures that use them.

## Creating plugin configurations

To create plugin configurations in CloudBees CD/RO, complete the following steps:

1. Navigate to DevOps Essentials  Plugin Management  Plugin configurations.
2. Select Add plugin configuration to create a new configuration.
3. In the New Configuration window, specify a Name for the configuration.
4. Select the Project that the configuration belongs to.
5. Optionally, add a Description for the configuration.
6. Select the appropriate Plugin for the configuration.
7. Configure the parameters per the descriptions below.

<a name="procedures"/>

## Plugin procedures

<a name="deploy_procedures"/>

### Deploy Procedure


Example of `deploy` procedure that sets needed job properties for third-party artifacts.

#### Deploy Procedure parameters

<table>
  <tr>
    <th>Parameter</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>Deployment Artifacts</td>
    <td>Required. JSON input with appropriate format containing information about your third-party artifacts. </td>
  </tr>
</table>

Example:
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
        "detail2": "value2"
      }
    }
  ]
}
```


<a name="undeploy_procedures"/>

### Undeploy Procedure

Any undeploy procedure

#### Undeploy Procedure parameters

<table>
  <tr>
    <th>Parameter</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>Deployment Artifacts</td>
    <td>Required. JSON input with appropriate format containing information about your third-party artifacts. </td>
  </tr>
</table>

Example:
```json
      {
  "deploymentSystem": "Some3rdPartyTool",
  "deploymentUrl": "https://repository.sonatype.org/service/local/repositories/atlassian-maven-external/content/org/apache/tomcat/apache-tomcat/",
  "artifacts": [
    "artifact1",
    "artifact2",
    "artifact3",
    "artifact1x",
    "artifact2x",
    "artifact3x"
  ]
}
```

<a name="rns"/>

## Release notes


### BringYourOwnDeployerPlugin 0.0.1

- Initial draft version


