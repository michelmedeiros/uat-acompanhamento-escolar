package br.com.acompanhamento;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber" },
        features = { "src/test/resources/br/com/acompanhamento/buscarPlanos.feature" },
        tags = { "~@ignore" })
public class BuscarPlanosTest {
}
