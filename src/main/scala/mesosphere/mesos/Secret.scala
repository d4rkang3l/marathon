package mesosphere.mesos

import org.apache.mesos.{ Protos => mesos }

object Secret {
  def toSecretReference(secret: String): mesos.Secret = {
    val builder = mesos.Secret.newBuilder
    builder.setType(mesos.Secret.Type.REFERENCE)
    val referenceBuilder = mesos.Secret.Reference.newBuilder
    referenceBuilder.setName(secret)
    builder.setReference(referenceBuilder)
    builder.build
  }
}
