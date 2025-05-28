pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ThinkUp"

include(":app")

// core
include(
    ":core:ui",
    ":core:util",
    ":core:data",
    ":core:model",
    ":core:domain",
    ":core:database",
    ":core:datastore",
    ":core:designsystem"
    ":core:navigation"
)

// feature
include(":feature:home")
