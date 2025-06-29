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
        maven { url = uri("https://jitpack.io") }
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
    ":core:designsystem",
    ":core:navigation",
    ":core:common"
)

// feature
include(
    ":feature:home",
    ":feature:goal",
    ":feature:planner",
    ":feature:memo",
    ":feature:thought",
    ":feature:widget"
)
include(":app-tu-catalog")
