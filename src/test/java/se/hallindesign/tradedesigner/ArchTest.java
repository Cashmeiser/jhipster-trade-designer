package se.hallindesign.tradedesigner;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("se.hallindesign.tradedesigner");

        noClasses()
            .that()
            .resideInAnyPackage("se.hallindesign.tradedesigner.service..")
            .or()
            .resideInAnyPackage("se.hallindesign.tradedesigner.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..se.hallindesign.tradedesigner.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
