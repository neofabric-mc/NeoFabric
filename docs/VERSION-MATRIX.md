# NeoFabric 版本矩阵

Java 列指 Minecraft 运行时与集成工程编译器。Gradle 宿主使用 Java 21。NeoFabric 版本号沿用 1.2.0，Fabric 官方 Loader 0.14.25 仅供 1.18.2 基线对照。Loom 1.11-SNAPSHOT 是仓库的现有声明。

| Minecraft | Yarn | Loader | Java | Loom |
| --- | --- | --- | --- | --- |
| 1.18.2 | 1.18.2+build.4 | NeoFabric 1.2.0（1.18.2 专用） | 17 | 1.11-SNAPSHOT |
| 1.20.1 | 1.20.1+build.10 | NeoFabric 1.2.0 | 17 | 1.11-SNAPSHOT |
| 1.20.2 | 1.20.2+build.4 | NeoFabric 1.2.0 | 17 | 1.11-SNAPSHOT |
| 1.20.3 | 1.20.3+build.1 | NeoFabric 1.2.0 | 17 | 1.11-SNAPSHOT |
| 1.20.4 | 1.20.4+build.3 | NeoFabric 1.2.0 | 17 | 1.11-SNAPSHOT |
| 1.20.5 | 1.20.5+build.1 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |
| 1.20.6 | 1.20.6+build.3 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |
| 1.21 | 1.21+build.9 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |
| 1.21.1 | 1.21.1+build.3 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |
| 1.21.2 | 1.21.2+build.1 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |
| 1.21.3 | 1.21.3+build.2 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |
| 1.21.4 | 1.21.4+build.8 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |
| 1.21.5 | 1.21.5+build.1 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |
| 1.21.6 | 1.21.6+build.1 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |
| 1.21.7 | 1.21.7+build.8 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |
| 1.21.8 | 1.21.8+build.1 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |
| 1.21.9 | 1.21.9+build.1 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |
| 1.21.10 | 1.21.10+build.3 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |
| 1.21.11 | 1.21.11+build.6 | NeoFabric 1.2.0 | 21 | 1.11-SNAPSHOT |

标准 Loader jar 覆盖表中原有 18 个版本。单独执行 `gradlew build -Pmc=1.18.2` 输出 `neofabric-<mcver>-<modver>.jar`，发布示例为 `neofabric-1.18.2-1.2.0.jar`。
