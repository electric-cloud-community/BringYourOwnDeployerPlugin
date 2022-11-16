
// DO NOT EDIT THIS BLOCK BELOW=== Parameters starts ===
// PLEASE DO NOT EDIT THIS FILE

import com.cloudbees.flowpdf.StepParameters

class DeployProcedureParameters {
    /**
    * Label: Use Default Artifacts, type: checkbox
    */
    boolean useDefaultArtifacts
    /**
    * Label: Deployment Artifacts, type: textarea
    */
    String deploymentArtifacts

    static DeployProcedureParameters initParameters(StepParameters sp) {
        DeployProcedureParameters parameters = new DeployProcedureParameters()

        def useDefaultArtifacts = sp.getParameter('useDefaultArtifacts').value == "true"
        parameters.useDefaultArtifacts = useDefaultArtifacts

        def deploymentArtifacts = sp.getParameter('deploymentArtifacts').value
        parameters.deploymentArtifacts = deploymentArtifacts

        return parameters
    }
}
// DO NOT EDIT THIS BLOCK ABOVE ^^^=== Parameters ends, checksum: 38a7cc22e160aef59464b43d113cbca8 ===
