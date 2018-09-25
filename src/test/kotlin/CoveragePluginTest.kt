import junit.framework.TestCase
import org.gradle.testkit.runner.GradleRunner
import org.intellij.l10n.LocalizationCoveragePlugin
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * @author traff
 */

open class CoveragePluginTest {
    @get:Rule val folder = TemporaryFolder()

    @Test
    fun testTaskExists() {
        folder.newFile("build.gradle").run {
            writeText("""
            plugins {
                id "org.intellij.l10n.coverage"
            }

            coverage {
                dir = ""
                outputDir = ""
            }


        """)

            val buildResult = GradleRunner.create().withProjectDir(folder.root).withPluginClasspath().withArguments("tasks", "--all").build()

            Assert.assertTrue(buildResult.output.contains(LocalizationCoveragePlugin.LOCALIZATION_COVERAGE_REPORT_TASK))
        }
    }
}

