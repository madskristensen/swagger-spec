import com.fasterxml.jackson.databind.JsonNode
import com.github.fge.jsonschema.core.exceptions.ProcessingException
import com.github.fge.jsonschema.main.{ JsonSchema, JsonSchemaFactory}
import com.github.fge.jsonschema.core.report.ProcessingReport
import com.github.fge.jackson.JsonLoader

import com.fasterxml.jackson.databind.ObjectMapper

import scala.io.Source

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class ModelTest extends FlatSpec with ShouldMatchers {
  val mapper = new ObjectMapper
  val schema = mapper.readTree(Source.fromFile("schemas/v2.0/modelSchema.json").mkString)
  val factory = JsonSchemaFactory.byDefault()
  val jsonSchema = factory.getJsonSchema(schema)

  it should "validate a model with string property" in {
    val json = Source.fromFile("samples/v2.0/json/models/modelWithStringProperty.json").mkString
    val data = JsonLoader.fromString(json)
    val report = jsonSchema.validate(data)
    if(report.isSuccess == false)
      println(report)
    report.isSuccess should be (true)
  }

  it should "validate a model with multiple properties" in {
    val json = Source.fromFile("samples/v2.0/json/models/modelWithMultipleProperties.json").mkString
    val data = JsonLoader.fromString(json)
    val report = jsonSchema.validate(data)
    if(report.isSuccess == false)
      println(report)
    report.isSuccess should be (true)
  }

  it should "validate a model with an int32 map" in {
    val json = Source.fromFile("samples/v2.0/json/models/modelWithInt32Map.json").mkString
    val data = JsonLoader.fromString(json)
    val report = jsonSchema.validate(data)
    if(report.isSuccess == false)
      println(report)
    report.isSuccess should be (true)
  }

  it should "validate a model with an int64 map" in {
    val json = Source.fromFile("samples/v2.0/json/models/modelWithInt64Map.json").mkString
    val data = JsonLoader.fromString(json)
    val report = jsonSchema.validate(data)
    if(report.isSuccess == false)
      println(report)
    report.isSuccess should be (true)
  }

  it should "validate a model with an date-time map" in {
    val json = Source.fromFile("samples/v2.0/json/models/modelWithDateTimeMap.json").mkString
    val data = JsonLoader.fromString(json)
    val report = jsonSchema.validate(data)
    if(report.isSuccess == false)
      println(report)
    report.isSuccess should be (true)
  }
}