
// DO NOT EDIT THIS BLOCK BELOW=== Parameters starts ===
// PLEASE DO NOT EDIT THIS FILE

import com.cloudbees.flowpdf.StepParameters

class DeployProcedureParameters {
    /**
    * Label: Deployment Artifacts, type: textarea
    */
    String deploymentArtifacts

    static DeployProcedureParameters initParameters(StepParameters sp) {
        DeployProcedureParameters parameters = new DeployProcedureParameters()

        def deploymentArtifacts = sp.getParameter('deploymentArtifacts').value
        parameters.deploymentArtifacts = deploymentArtifacts

        return parameters
    }
}
// DO NOT EDIT THIS BLOCK ABOVE ^^^=== Parameters ends, checksum: c87f9344e50c2a8868a5c73fcb88f48d ===
