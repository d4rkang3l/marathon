package mesosphere.mesos

import com.google.protobuf.ByteString
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

  def toSecretValue(value: String): mesos.Secret = {
    val builder = mesos.Secret.newBuilder
    builder.setType(mesos.Secret.Type.VALUE)
    val valueBuilder = mesos.Secret.Value.newBuilder
    valueBuilder.setData(ByteString.copyFromUtf8(value))
    builder.setValue(valueBuilder)
    builder.build
  }
}
