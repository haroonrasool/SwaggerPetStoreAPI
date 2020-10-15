package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwaggerStepDefs {
    String url;
    String domain = "https://petstore.swagger.io/v2/";

    @Given("user hits the endpoint {string}")
    public void user_hits_the_endpoint(String endpoint) {
        this.url = domain + endpoint;
    }

    @Given("user sets the accept header to {string}")
    public void user_sets_the_accept_header_to(String string) {
    }

    @When("user registers with the following details")
    public void user_registers_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
    }

    @Given("I hit the endpoint {string}")
    public void i_hit_the_endpoint(String string) {
    }

    @Given("I set accept header to {string}")
    public void i_set_accept_header_to(String string) {
    }

    @When("I register with the following details")
    public void i_register_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
    }

    @Given("I run this API test in WireMock")
    public void i_run_this_API_test_in_WireMock() {
    }

    @Then("the response code should be {int}")
    public void the_response_code_should_be(Integer int1) {
    }

    @Then("the count of matching pets should be {int}")
    public void the_count_of_matching_pets_should_be(Integer int1) {
    }
}
