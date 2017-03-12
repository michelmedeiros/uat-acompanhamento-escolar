package br.com.acompanhamento.stepdefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber" }, features = { "src/test/resources/com/netshoes/mp/commission/closeCycle.feature" }, tags = { "~@ignore" })
public class BuscarAlunosTest {
}
