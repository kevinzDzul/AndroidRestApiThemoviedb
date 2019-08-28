package com.rappi.apple.rappitest

object Libs {

    object Android {
        const val APP_COMPAT = "com.android.support:appcompat-v7:${Versions.Android.APP_COMPAT}"
        const val TOOLS_BUILD_GRADLE = "com.android.tools.build:gradle:${Versions.Android.TOOLS_BUILD_GRADLE}"
    }

    object Testing {
        const val JUNIT = "junit:junit:${Versions.Testing.JUNIT}"
        const val RUNNER = "com.android.support.test:runner:${Versions.Testing.RUNNER}"
        const val ESPRESSO = "com.android.support.test.espresso:espresso-core:${Versions.Testing.ESPRESSO}"
    }

    object NetWork {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.Network.RETROFIT}"
        const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.Network.RETROFIT_GSON}"
    }

    object Storage {
        const val REALM = "io.realm:realm-gradle-plugin:${Versions.Storage.REALM}"
    }

    object UI {
        const val CONSTRAINT_LAYOUT = "com.android.support.constraint:constraint-layout:${Versions.UI.CONSTRAINT_LAYOUT}"
        const val RECYCLER_VIEW = "com.android.support:recyclerview-v7:${Versions.UI.RECYCLERVIEW}"
        const val CARD_VIEW = "com.android.support:cardview-v7:${Versions.UI.CARD_VIEW}"
        const val GLIDE = "com.github.bumptech.glide:glide:${Versions.UI.GLIDE}"
        const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.UI.GLIDE}"
    }

    object DependencyInversion {
        const val BUTTERKNIFE = "com.jakewharton:butterknife:${Versions.DependencyInversion.BUTTERKNIFE}"
        const val BUTTERKNIFE_COMPILER = "com.jakewharton:butterknife-compiler:${Versions.DependencyInversion.BUTTERKNIFE_COMPILER}"

    }

    object Asynchronous {
        const val RX_JAVA = "io.reactivex.rxjava2:rxjava:${Versions.Asynchronous.RX_JAVA}"
        const val RX_JAVA_ADAPTER = "com.squareup.retrofit2:adapter-rxjava2:${Versions.Asynchronous.RX_JAVA_ADAPTER}"
        const val RX_ANDROID = "io.reactivex.rxjava2:rxandroid:${Versions.Asynchronous.RX_ANDROID}"

    }
}