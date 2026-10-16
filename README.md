# 学生管理系统（Java CRUD）

一个控制台版的学生管理系统，支持学生信息的增、删、改、查。

## 环境要求

- JDK 17 及以上
- 不需要安装 Maven，项目自带 Maven Wrapper（首次运行会自动下载 Maven）

## 构建与运行

```bash
# macOS / Linux
./mvnw package
java -jar target/java-crud-1.0-SNAPSHOT.jar

# Windows
mvnw.cmd package
java -jar target\java-crud-1.0-SNAPSHOT.jar
```

也可以用 IntelliJ IDEA 直接打开项目根目录（会识别为 Maven 项目），运行 `Main`。

## 功能

| 菜单 | 功能 |
| --- | --- |
| 1 | 添加学生 |
| 2 | 查看所有学生 |
| 3 | 按学号查询 |
| 4 | 修改学生 |
| 5 | 删除学生 |
| 0 | 退出 |

## 项目结构

```
src/
├── Main.java            # 控制台菜单与输入处理
├── Student.java         # 学生实体
└── StudentService.java  # 增删改查逻辑
doc/                     # 运行截图与日志
```
