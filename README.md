# TODO Application with Quarkus Eclipse JKube Sample

This is an Eclipse JKube sample for Deploying a Quarkus based application on top of OpenShift using OpenShift Maven Plugin.

## Deploying to OpenShift
OpenShift Maven Plugin is already included in pom. You just need to run:

```bash
mvn package oc:build oc:resource oc:apply
```

Access created `Route`.
