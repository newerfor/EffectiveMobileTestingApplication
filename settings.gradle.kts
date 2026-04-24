pluginManagement {
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

rootProject.name = "EffectiveMobileTestingApplication"
include(":app")
include(":core:core-navigation")

include(":core:core-ui")
include(":feature:feature-login")
include(":core:core-viewmodel")
include(":core:core-domain")
include(":feature:feature-main")
include(":core:core-data")
include(":feature:feature-favorit-course")
include(":feature:feature-single-course")
include(":feature:feature-profile")
