Pre-req's:

* Java 6 or later
* Ant 1.7.1 or later

Usage:

An individual bundle may be added to the repository by creating a suitable directory structure inside the
bundles directory and then issuing:

ant publish

The bundle is published into the Maven and Ivy repositories in publish-dir.

ant clean will clean up the target directory for the particular bundle.

A "top-level" build may be performed from bundles/build-bundles using the same ant target which is then
distributed to the bundles in bundle dependency order (as defined by the Ivy dependencies between the bundles).

Some examples are provided.

1. Bundle Generation Example

bundles/org.apache.commons/org.bundlerepo.org.apache.commons.logging/1.1.1 contains the files
necessary to pubish an Apache Commons Logging bundle. Since the Apache Commons
Logging project provides this as a JAR, a manifest template is provided which configures
the bundlor tool in creating a manifest in the published bundle.

Note that the bundle symbolic name is prefixed with "org.bundlerepo" to avoid clashes should
the Apache Commons Logging project decide to produce bundle manifests in the future.

This bundle has some transitive dependencies such as a javax.servlet bundle which are also provided.

2. Pre-built Bundle Example

bundles/org.eclipse.osgi/org.eclipse.osgi/3.7.0.v20110224 contains the files necessary for publishing
the corresponding Equinox bundle. Since the Equinox project provides this as a bundle, no manifest
template is required.